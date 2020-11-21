package com.ihorpolataiko.springbootddddemo.feedback.repository;

import com.ihorpolataiko.springbootddddemo.feedback.domain.Feedback;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Long> {

    List<Feedback> findAll();

}
