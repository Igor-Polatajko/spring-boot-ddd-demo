package com.ihorpolataiko.springbootddddemo.feedback.api.impl;

import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;
import com.ihorpolataiko.springbootddddemo.feedback.api.FeedbackApi;
import com.ihorpolataiko.springbootddddemo.feedback.service.FeedbackService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackApiImpl implements FeedbackApi {

    private FeedbackService feedbackService;

    public FeedbackApiImpl(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public FeedbackDto findById(Long id) {
        return feedbackService.findById(id);
    }

    @Override
    public List<FeedbackDto> findAll() {
        return feedbackService.findAll();
    }

    @Override
    public FeedbackDto create(FeedbackDto feedbackDto) {
        return feedbackService.create(feedbackDto);
    }

    @Override
    public FeedbackDto update(Long id, FeedbackDto feedbackDto) {
        return feedbackService.update(id, feedbackDto);
    }

    @Override
    public void deleteById(Long id) {
        feedbackService.deleteById(id);
    }
}
