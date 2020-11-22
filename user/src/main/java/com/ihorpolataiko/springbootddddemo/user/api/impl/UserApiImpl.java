package com.ihorpolataiko.springbootddddemo.user.api.impl;

import com.ihorpolataiko.springbootddddemo.user.api.UserApi;
import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;
import com.ihorpolataiko.springbootddddemo.user.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserApiImpl implements UserApi {

    private UserService userService;

    public UserApiImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto findById(Long id) {
        return userService.findById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public UserDto create(UserDto userDto) {
        return userService.create(userDto);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return userService.update(id, userDto);
    }

    @Override
    public UserDto deactivateById(Long id) {
        return userService.deactivateById(id);
    }

    @Override
    public UserDto activateById(Long id) {
        return userService.activateById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userService.existsById(id);
    }
}
