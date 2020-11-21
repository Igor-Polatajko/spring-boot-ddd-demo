package com.ihorpolataiko.springbootddddemo.rest.resource;

import com.ihorpolataiko.springbootddddemo.rest.dto.DummyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dummy")
public class DummyResource {

    @GetMapping
    public DummyDto getDummyResponse() {
        return new DummyDto("Some body");
    }

}
