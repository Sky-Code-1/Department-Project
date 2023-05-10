package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.requests.LecturerRequest;
import org.flexicode.web.service.LecturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecturer")
public class LecturerController {

    private final LecturerService service;


    @PostMapping("/add")
    public void saveAll(@RequestBody LecturerRequest... lecturers){
            service.addLecturer(lecturers);
            System.out.println("Successfully added " + lecturers.length + " lecturers to the list of lecturers");
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Lecturer>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}