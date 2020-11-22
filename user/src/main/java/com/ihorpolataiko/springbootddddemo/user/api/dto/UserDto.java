package com.ihorpolataiko.springbootddddemo.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private boolean active;

    private LocalDateTime createdAt;

}

