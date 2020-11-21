package com.ihorpolataiko.springbootddddemo.rest.resource;

import com.ihorpolataiko.springbootddddemo.feedback.api.FeedbackApi;
import com.ihorpolataiko.springbootddddemo.feedback.api.dto.FeedbackDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackResource {


    private FeedbackApi feedbackApi;

    public FeedbackResource(FeedbackApi feedbackApi) {
        this.feedbackApi = feedbackApi;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public FeedbackDto findById(@PathVariable("id") Long id) {
        return feedbackApi.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<FeedbackDto> findAll() {
        return feedbackApi.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    FeedbackDto create(@RequestBody FeedbackDto feedbackDto) {
        return feedbackApi.create(feedbackDto);
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    FeedbackDto update(@PathVariable("id") Long id, @RequestBody FeedbackDto feedbackDto) {
        return feedbackApi.update(id, feedbackDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") Long id) {
        feedbackApi.deleteById(id);
    }

}
