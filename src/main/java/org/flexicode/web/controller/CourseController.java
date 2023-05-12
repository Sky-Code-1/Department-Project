package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.Student;
import org.flexicode.web.requests.CourseRequest;
import org.flexicode.web.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Course getCourseById(@PathVariable String id){
        long courseId = Long.parseLong(id);
        return service.getCourseById(courseId);
    }
//    @GetMapping("/get/{name}/students")
//    public ResponseEntity<List<Student>> getStudentOfferingCourse(@PathVariable String name){
//        return ResponseEntity.ok();
//    }

}
