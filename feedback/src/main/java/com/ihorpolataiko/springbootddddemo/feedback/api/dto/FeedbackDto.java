package com.ihorpolataiko.springbootddddemo.feedback.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackDto {

    private Long id;

    @NotEmpty
    private String content;

    @NotNull
    private Long userId;

    private LocalDateTime createdAt;

}
