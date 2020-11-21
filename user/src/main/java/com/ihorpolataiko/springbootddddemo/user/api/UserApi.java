package com.ihorpolataiko.springbootddddemo.user.api;

import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;

import java.util.List;

public interface UserApi {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto create(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    void deleteById(Long id);

    boolean existsById(Long id);

}
