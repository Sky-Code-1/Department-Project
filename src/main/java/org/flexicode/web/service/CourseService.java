package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.*;
import org.flexicode.web.requests.CourseRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


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
        System.out.println("retrieving course from db");
        return repo.findAll();
    }
    public Course getCourseById(long courseId) {
        if(repo.existsById(courseId))
            return repo.findById(courseId).get();
        else
            throw new ObjectNotFoundException("Object was not found", Course.class);
    }
   public void updateCourse(String courseName, Course course){
        Course toUpdate = repo.findByCourseName(courseName).stream().findFirst().orElseThrow(ResourceNotFoundException::new);
        Set<Student> students = toUpdate.getStudents();
        students.addAll(course.getStudents());
        toUpdate.setStudents(students);
        repo.save(toUpdate);
   }

    public Set<Lecturer> getLecturers(String id) {
        return repo.findById(Long.parseLong(id))
                .orElseThrow()
                .getLecturers();
    }
}
