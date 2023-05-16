package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.requests.LecturerRequest;
import org.flexicode.web.service.LecturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecturers")
public class LecturerController {

    private final LecturerService service;


    @PostMapping("/add")
    public void saveAll(@RequestBody LecturerRequest... lecturers){
            service.addLecturer(lecturers);
            System.out.println("Successfully added " + lecturers.length + " lecturers to the list of lecturers");
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<Lecturer>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}/schedule")
    public ResponseEntity<Map<DayOfWeek, List<String>>> getSchedule(@PathVariable String id){
        return ResponseEntity.ok(service.getSchedule(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturer(@PathVariable String id){
        return ResponseEntity.ok(service.getLecturer(id));
    }
    @GetMapping("/{id}/course")
    public ResponseEntity<Set<Course>> getLecturerCourses(@PathVariable String id){
        return ResponseEntity.ok(service.getLecturerCourses(id));
    }
}