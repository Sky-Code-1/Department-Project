package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.requests.CourseRequest;
import org.flexicode.web.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;
    @PostMapping("/add")
    public void saveAll(@RequestBody CourseRequest... requests){
        service.saveAll(requests);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Course>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id){
        long courseId = Long.parseLong(id);
        return ResponseEntity.ok(service.getCourseById(courseId));
    }
    @GetMapping("/{id}/lecturers")
    public ResponseEntity<Set<Lecturer>> getLecturers(@PathVariable String id){
        return ResponseEntity.ok(service.getLecturers(id));
    }
}
