package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.CourseAdvisor;
import org.flexicode.web.service.CourseAdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisor")
@RequiredArgsConstructor
public class AdvisorController {

    private final CourseAdvisorService service;
    @GetMapping("/get/all")
    public ResponseEntity<List<CourseAdvisor>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{level}")
    public ResponseEntity<CourseAdvisor> getAdvisorByLevel(@PathVariable String level){
        return ResponseEntity.ok(service.getAdvisorByLevel(level));
    }

    @PostMapping("/add")
    public void addAdvisor(@RequestBody AdvisorRequest request){
        service.addAdvisor(request);
    }

}
