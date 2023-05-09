package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.CourseRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository repo;
    @PostMapping("/api/v1/dept/courses/add-all")
    public void addAllCourses(@RequestBody Course... courses){
        repo.saveAll(List.of(courses));
    }
}
