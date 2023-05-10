package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.CourseRepository;
import org.flexicode.web.requests.CourseRequest;
import org.flexicode.web.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository repo;
    private final CourseService service;
    @PostMapping("/add/courses")
    public void addAllCourses(@RequestBody CourseRequest... requests){
        service.saveAll(requests);
    }
}
