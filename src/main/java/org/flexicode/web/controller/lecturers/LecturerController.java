package org.flexicode.web.controller.lecturers;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.entity.LecturerRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerRepository repo;


    @RequestMapping("/api/v1/dept/lecturers/add-all")
    public void saveAll(@RequestBody Lecturer... lecturers){
        for (Lecturer l: lecturers) {
            repo.save(l);
        }
        System.out.println("Successfully added " + lecturers.length + " lecturers to the list of lecturers");
    }

}

