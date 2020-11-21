package com.ihorpolataiko.springbootddddemo.feedback.mapper;

import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;
import com.ihorpolataiko.springbootddddemo.feedback.domain.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackDto mapToDto(Feedback feedback) {
        return FeedbackDto.builder()
                .id(feedback.getId())
                .content(feedback.getContent())
                .userId(feedback.getUserId())
                .build();
    }

    public Feedback toDomain(FeedbackDto feedbackDto) {
        return Feedback.builder()
                .id(feedbackDto.getId())
                .content(feedbackDto.getContent())
                .userId(feedbackDto.getUserId())
                .build();
    }
}
