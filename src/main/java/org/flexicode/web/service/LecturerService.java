package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.Course;
import org.flexicode.web.entity.CourseRepository;
import org.flexicode.web.entity.Lecturer;
import org.flexicode.web.entity.LecturerRepository;
import org.flexicode.web.exception.CourseNotFoundException;
import org.flexicode.web.exception.LecturerNotFoundException;
import org.flexicode.web.requests.LecturerRequest;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

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
            courses.forEach(c -> {
                course.add(cRepo.findCourseByCourseCode(c).stream().findFirst().orElseThrow(CourseNotFoundException::new));
            });
            lecturerBuilder.courses(course);
            if(post != null)
                lecturerBuilder.position(post).hasPost(true);
            var lecturer = lecturerBuilder.firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .title(request.getTitle())
                    .email(request.getEmail())
                    .build();
            repo.save(lecturer);
        }
    }

    public List<Lecturer> getAll() {
        return repo.findAll();
    }

    public Map<DayOfWeek, List<String>> getSchedule(String id) {
        Lecturer lecturer = repo.findById(Long.parseLong(id))
                .stream()
                .findFirst()
                .orElseThrow(LecturerNotFoundException::new);
        Map<DayOfWeek, List<String>> schedule = new HashMap<>();
        var courses = lecturer.getCourses();
        schedule.put(DayOfWeek.MONDAY, new ArrayList<String>());
        schedule.put(DayOfWeek.TUESDAY, new ArrayList<String>());
        schedule.put(DayOfWeek.WEDNESDAY, new ArrayList<String>());
        schedule.put(DayOfWeek.THURSDAY, new ArrayList<String>());
        schedule.put(DayOfWeek.FRIDAY, new ArrayList<String>());
        schedule.put(DayOfWeek.SATURDAY, new ArrayList<String>());

        courses.forEach(c -> {
            List<DayOfWeek> days = new ArrayList<>();
            days = c.getLectureDays();
            days.forEach(day -> {
                switch (day) {
                    case MONDAY, TUESDAY,  WEDNESDAY, THURSDAY, FRIDAY, SATURDAY -> {
                        String lecturerSchedule = c.getCourseName();
                        schedule.get(day).add(lecturerSchedule);
                        if(schedule.get(day).isEmpty())
                            schedule.get(day).add("Office Hour");
                    }
                }
            });
        });
        return schedule;
    }

    public Lecturer getLecturer(String lecturerId){
        return repo.findById(Long.parseLong(lecturerId)).stream().findFirst().orElseThrow(LecturerNotFoundException::new);
    }

    public Set<Course> getLecturerCourses(String id) {
        return repo.findById(Long.parseLong(id)).stream().findFirst().orElseThrow(LecturerNotFoundException::new).getCourses();
    }

    public List<Lecturer> getSomeLecturers(long i) {
        return repo.findByIdLessThanEqual(i);
    }
}
