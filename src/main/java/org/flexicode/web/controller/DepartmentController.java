package org.flexicode.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DepartmentController {

    @GetMapping("/home")
    public String homepage(){
        return "home.html";
    }
}
