package com.ihorpolataiko.springbootddddemo.feedback.api;

import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;

import java.util.List;

public interface FeedbackApi {

    FeedbackDto findById(Long id);

    List<FeedbackDto> findAll();

    FeedbackDto create(FeedbackDto feedbackDto);

    FeedbackDto update(Long id, FeedbackDto feedbackDto);

    void deleteById(Long id);

}
