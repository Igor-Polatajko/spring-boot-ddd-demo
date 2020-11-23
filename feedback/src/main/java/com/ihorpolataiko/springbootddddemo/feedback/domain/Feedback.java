package com.ihorpolataiko.springbootddddemo.feedback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Feedback {

    @Id
    private Long id;

    private String content;

    private Long userId;

    private LocalDateTime createdAt;

}
