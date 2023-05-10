package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.*;
import org.flexicode.web.requests.StudentRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final AdvisorRepo repo;
    private final StudentRepository sRepo;
    private final CourseRepository cRepo;
    public void saveStudent(@RequestBody StudentRequest... r){
        List<Student> students = new ArrayList<>();
        for(StudentRequest request: r){
            String level = request.getLevel();
            Set<Course> courses = cRepo.findByLevel(level);
            Optional<CourseAdvisor> advisor = repo.findByLevel(level);
            CourseAdvisor courseAdvisor;
            if (advisor.isEmpty()) {
                var student = Student.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .level(level)
                        .courses(courses)
                        .build();
                sRepo.save(student);
            }
            else {
                var student = Student.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .level(level)
                        .courses(courses)
                        .courseAdvisor(advisor.get())
                        .build();
                sRepo.save(student);
            }
        }
    }
}
