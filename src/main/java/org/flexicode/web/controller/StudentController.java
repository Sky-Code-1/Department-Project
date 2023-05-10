package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.AdvisorRepo;
import org.flexicode.web.entity.CourseAdvisor;
import org.flexicode.web.entity.Student;
import org.flexicode.web.entity.StudentRepository;
import org.flexicode.web.requests.StudentRequest;
import org.flexicode.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StudentController {
    private final AdvisorRepo repo;
    private final StudentService studentService;

    @PostMapping("/add")
    public void saveStudents(@RequestBody StudentRequest... requests){
       studentService.saveStudent(requests);
    }
    @GetMapping("/homepage")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Welcome to the homepage");
    }
}
