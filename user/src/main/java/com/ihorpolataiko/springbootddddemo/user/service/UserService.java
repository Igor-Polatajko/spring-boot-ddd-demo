package com.ihorpolataiko.springbootddddemo.user.service;

import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto create(UserDto userDto);

    UserDto update(Long id, UserDto user);

    UserDto deactivateById(Long id);

    UserDto activateById(Long id);

    boolean existsById(Long id);
}
