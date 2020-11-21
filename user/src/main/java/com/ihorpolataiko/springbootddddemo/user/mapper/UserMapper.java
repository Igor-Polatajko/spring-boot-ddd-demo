package com.ihorpolataiko.springbootddddemo.user.mapper;

import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;
import com.ihorpolataiko.springbootddddemo.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public User toDomain(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .createdAt(userDto.getCreatedAt())
                .build();
    }

}
