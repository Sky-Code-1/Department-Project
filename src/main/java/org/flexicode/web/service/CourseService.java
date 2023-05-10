package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.*;
import org.flexicode.web.requests.CourseRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repo;
    private final StudentRepository sRepo;
    private final List<Course> courses = new ArrayList<>();
    public void saveAll(CourseRequest... request) {
        for (CourseRequest r: request) {
            var course = Course.builder()
                    .courseCode(r.getCourseCode())
                    .courseCredit(r.getCourseCredit())
                    .courseName(r.getCourseName())
                    .lectureDays(r.getLectureDays())
                    .level(r.getLevel())
                    .build();
            repo.save(course);
        }
    }
    public List<Course> getAll(){
        return repo.findAll();
    }
    public Course getCourseById(long courseId) {
        if(repo.existsById(courseId))
            return repo.findById(courseId).get();
        else
            throw new ObjectNotFoundException("Object was not found", Course.class);
    }
}
