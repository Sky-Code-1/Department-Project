package org.flexicode.web.controller;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.entity.Student;
import org.flexicode.web.service.LecturerService;
import org.flexicode.web.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class DepartmentController {

    private final StudentService service;
    private final LecturerService lService;
    @GetMapping("/")
    public String homepage(Model model){
        List<Student> s = new ArrayList<>(service.getSomeStudents(6));
        List<Lecturer> l = new ArrayList<>(lService.getSomeLecturers(5));
        model.addAttribute("students", s);
        model.addAttribute("lecturers", l);
        for(int i = 0; i < s.size(); i++)
            System.out.println(s.get(i).getFirstname());
        return "dept.html";
    }
}
