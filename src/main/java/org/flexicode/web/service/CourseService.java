package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.CourseRepository;
import org.flexicode.web.entity.Student;
import org.flexicode.web.entity.StudentRepository;
import org.flexicode.web.requests.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
