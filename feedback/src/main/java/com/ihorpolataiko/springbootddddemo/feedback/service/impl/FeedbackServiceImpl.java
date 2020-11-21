package com.ihorpolataiko.springbootddddemo.feedback.service.impl;

import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;
import com.ihorpolataiko.springbootddddemo.user.api.UserApi;
import com.ihorpolataiko.springbootddddemo.feedback.domain.Feedback;
import com.ihorpolataiko.springbootddddemo.feedback.mapper.FeedbackMapper;
import com.ihorpolataiko.springbootddddemo.feedback.repository.FeedbackRepository;
import com.ihorpolataiko.springbootddddemo.feedback.service.FeedbackService;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("Feedback not found!"));
    }

    @Override
    public List<FeedbackDto> findAll() {
        return feedbackRepository.findAll().stream()
                .map(feedbackMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto create(FeedbackDto feedbackDto) {

        if (!userApi.existsById(feedbackDto.getUserId())) {
            throw new RuntimeException("User not found");
        }

        Feedback feedback = feedbackMapper.toDomain(feedbackDto);

        return feedbackMapper.mapToDto(
                feedbackRepository.save(feedback)
        );
    }

    @Override
    public FeedbackDto update(Long id, FeedbackDto feedbackDto) {

        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Feedback not found");
        }

        Feedback feedback = feedbackMapper.toDomain(feedbackDto).toBuilder()
                .id(id)
                .build();

        return feedbackMapper.mapToDto(
                feedbackRepository.save(feedback)
        );
    }

    @Override
    public void deleteById(Long id) {

        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Feedback not found");
        }

        feedbackRepository.deleteById(id);
    }
}
