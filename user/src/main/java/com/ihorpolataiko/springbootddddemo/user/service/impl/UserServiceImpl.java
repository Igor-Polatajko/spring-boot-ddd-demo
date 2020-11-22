package com.ihorpolataiko.springbootddddemo.user.service.impl;

import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;
import com.ihorpolataiko.springbootddddemo.user.domain.User;
import com.ihorpolataiko.springbootddddemo.user.mapper.UserMapper;
import com.ihorpolataiko.springbootddddemo.user.repository.UserRepository;
import com.ihorpolataiko.springbootddddemo.user.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserDto userDto) {

        User user = userMapper.toDomain(userDto).toBuilder()
                .createdAt(LocalDateTime.now())
                .build();

        return saveUser(user);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        User user = userMapper.toDomain(userDto).toBuilder()
                .id(id)
                .build();

        return saveUser(user);
    }

    @Override
    public UserDto deactivateById(Long id) {

        User updatedUser = findUserByIdOrThrowException(id).toBuilder()
                .active(false)
                .build();

        return saveUser(updatedUser);
    }

    @Override
    public UserDto activateById(Long id) {
        User updatedUser = findUserByIdOrThrowException(id).toBuilder()
                .active(true)
                .build();

        return saveUser(updatedUser);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    private UserDto saveUser(User updatedUser) {
        return userMapper.mapToDto(
                userRepository.save(updatedUser)
        );
    }

    private User findUserByIdOrThrowException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
