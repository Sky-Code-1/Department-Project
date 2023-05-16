package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.requests.AdvisorRequest;
import org.flexicode.web.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseAdvisorService {


    private final LecturerRepository repo;
    private final StudentRepository sRepo;
    private final AdvisorRepo aRepo;
    public void addAdvisor(AdvisorRequest request) {

        String email = request.getEmail();
        String level = request.getLevel();
        Lecturer lecturer = repo.findByEmailIgnoreCase(email);
        List<Student> students = sRepo.findByLevel(level);
        var advisor = CourseAdvisor.builder()
                .level(level)
                .advisor(lecturer)
                .email(email)
                .students(students)
                .build();
        aRepo.save(advisor);
    }

    public List<CourseAdvisor> getAll() {
        return aRepo.findAll();
    }

    public CourseAdvisor getAdvisorByLevel(String level) {
        return aRepo.findByLevel(level).stream().findFirst().orElseThrow();
    }

}
