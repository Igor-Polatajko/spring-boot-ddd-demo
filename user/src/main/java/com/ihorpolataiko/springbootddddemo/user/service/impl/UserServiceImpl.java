package com.ihorpolataiko.springbootddddemo.user.service.impl;

import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;
import com.ihorpolataiko.springbootddddemo.user.domain.User;
import com.ihorpolataiko.springbootddddemo.user.mapper.UserMapper;
import com.ihorpolataiko.springbootddddemo.user.repository.UserRepository;
import com.ihorpolataiko.springbootddddemo.user.service.UserService;
import org.springframework.stereotype.Service;

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

        User user = userMapper.toDomain(userDto);

        return userMapper.mapToDto(
                userRepository.save(user)
        );
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        User user = userMapper.toDomain(userDto).toBuilder()
                .id(id)
                .build();

        return userMapper.mapToDto(
                userRepository.save(user)
        );
    }

    @Override
    public void deleteById(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        // here somehow we would like to check if user has feedbacks

        userRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
