package com.ihorpolataiko.springbootddddemo.rest.resource;

import com.ihorpolataiko.springbootddddemo.user.api.UserApi;
import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private UserApi userApi;

    public UserResource(UserApi userApi) {
        this.userApi = userApi;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDto findById(@PathVariable("id") Long id) {
        return userApi.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAll() {
        return userApi.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userDto) {
        return userApi.create(userDto);
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return userApi.update(id, userDto);
    }

    @PostMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDto deactivate(@PathVariable("id") Long id) {
        return userApi.deactivateById(id);
    }

    @PostMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDto activate(@PathVariable("id") Long id) {
        return userApi.activateById(id);
    }

}
