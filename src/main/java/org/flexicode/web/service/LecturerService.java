package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.CourseRepository;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.entity.LecturerRepository;
import org.flexicode.web.requests.LecturerRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService {


    private final LecturerRepository repo;
    private final CourseRepository cRepo;
    public void addLecturer(LecturerRequest... requests){
        for(LecturerRequest request: requests){
            var lecturerBuilder = Lecturer.builder();
            var course = new HashSet<Course>();
            var post = request.getPosition();
            var courses = request.getCourse();
            System.out.println("Course is not null");
            courses.forEach(c -> {
                course.add(cRepo.findCourseByCourseCode(c).get());
            });
            lecturerBuilder.courses(course);
            if(post != null)
                lecturerBuilder.position(post).hasPost(true);
            var lecturer = lecturerBuilder.firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .title(request.getTitle())
                    .build();
            repo.save(lecturer);
        }
    }

    public List<Lecturer> getAll() {
        return repo.findAll();
    }

}
