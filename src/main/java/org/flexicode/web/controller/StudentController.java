package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.AdvisorRepo;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.CourseAdvisor;
import org.flexicode.web.entity.Student;
import org.flexicode.web.requests.StudentRequest;
import org.flexicode.web.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final AdvisorRepo repo;
    private final StudentService studentService;

    @PostMapping("/add")
    public void saveStudents(@RequestBody StudentRequest... requests){
       studentService.saveAllStudent(requests);
    }
    @PatchMapping("/{id}/update")
    public void updateStudent(@PathVariable String id, @RequestBody Map<String, Object> request){
        studentService.update(id, request);
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

//    @GetMapping("/?{level}")
//    public ResponseEntity<List<Student>> getByLevel(String level){
//        return ResponseEntity.ok(studentService.getStudentByLevel(level));
//    }
    @GetMapping("/{id}/schedule")
    public ResponseEntity<Map<DayOfWeek, List<String>>> getStudentSchedule(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudentSchedule(id));
    }

    @GetMapping("/{id}/course")
    public ResponseEntity<Set<Course>> getStudentCourse(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudentCourses(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @GetMapping("/{id}/advisor")
    public ResponseEntity<CourseAdvisor> getStudentCourseAdvisor(@PathVariable Object id){
        String studentId = id.toString();
        return ResponseEntity.ok(studentService.getStudentCourseAdvisor(studentId));
    }
}
