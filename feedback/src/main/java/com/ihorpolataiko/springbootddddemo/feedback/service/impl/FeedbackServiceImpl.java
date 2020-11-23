package com.ihorpolataiko.springbootddddemo.feedback.service.impl;

import com.ihorpolataiko.springbootddddemo.common.exception.NotFoundException;
import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;
import com.ihorpolataiko.springbootddddemo.feedback.domain.Feedback;
import com.ihorpolataiko.springbootddddemo.feedback.mapper.FeedbackMapper;
import com.ihorpolataiko.springbootddddemo.feedback.repository.FeedbackRepository;
import com.ihorpolataiko.springbootddddemo.feedback.service.FeedbackService;
import com.ihorpolataiko.springbootddddemo.user.api.UserApi;
import com.ihorpolataiko.springbootddddemo.user.api.dto.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedbackRepository;

    private FeedbackMapper feedbackMapper;

    private UserApi userApi;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper, UserApi userApi) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapper = feedbackMapper;
        this.userApi = userApi;
    }

    @Override
    public FeedbackDto findById(Long id) {
        return feedbackRepository.findById(id)
                .map(feedbackMapper::mapToDto)
                .orElseThrow(() -> new NotFoundException("Feedback not found!"));
    }

    @Override
    public List<FeedbackDto> findAll() {
        return feedbackRepository.findAll().stream()
                .map(feedbackMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto create(FeedbackDto feedbackDto) {

        UserDto user = userApi.findById(feedbackDto.getUserId());

        if (!user.isActive()) {
            throw new NotFoundException("User is not active!");
        }

        Feedback feedback = feedbackMapper.toDomain(feedbackDto).toBuilder()
                .createdAt(LocalDateTime.now())
                .build();

        return saveFeedback(feedback);
    }

    @Override
    public FeedbackDto update(Long id, FeedbackDto feedbackDto) {

        if (!feedbackRepository.existsById(id)) {
            throw new NotFoundException("Feedback not found");
        }

        Feedback feedback = feedbackMapper.toDomain(feedbackDto).toBuilder()
                .id(id)
                .build();

        return saveFeedback(feedback);
    }

    @Override
    public void deleteById(Long id) {

        if (!feedbackRepository.existsById(id)) {
            throw new NotFoundException("Feedback not found");
        }

        feedbackRepository.deleteById(id);
    }

    private FeedbackDto saveFeedback(Feedback feedback) {
        return feedbackMapper.mapToDto(
                feedbackRepository.save(feedback)
        );
    }
}
