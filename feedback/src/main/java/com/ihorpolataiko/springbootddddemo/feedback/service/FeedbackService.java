package com.ihorpolataiko.springbootddddemo.feedback.service;

import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {

    FeedbackDto findById(Long id);

    List<FeedbackDto> findAll();

    FeedbackDto create(FeedbackDto feedbackDto);

    FeedbackDto update(Long id, FeedbackDto feedbackDto);

    void deleteById(Long id);

}
