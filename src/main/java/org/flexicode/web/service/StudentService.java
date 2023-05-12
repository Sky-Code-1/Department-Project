package org.flexicode.web.service;

import lombok.RequiredArgsConstructor;
import org.flexicode.web.entity.*;
import org.flexicode.web.exception.StudentNotFoundException;
import org.flexicode.web.pojo.SaveStudents;
import org.flexicode.web.requests.StudentRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseService courseService;
    private final AdvisorRepo repo;
    private final StudentRepository sRepo;
    private final CourseRepository cRepo;


    public void saveAllStudent(StudentRequest... r){
        if(r.length > 100){
            int startIndex = 0;
            int endIndex = (int)(r.length / 4);
            int initialEndIndex = endIndex;
            SaveStudents[] save = new SaveStudents[4];
            for(int i = 0; i < 4; i++){
                StudentRequest[] requests = Arrays.copyOfRange(r,startIndex,endIndex);
                save[i] = new SaveStudents(new StudentService(this.courseService,this.repo,this.sRepo, this.cRepo), requests);
                startIndex = endIndex;
                endIndex = endIndex+initialEndIndex;
            }
            for(int i = 0; i < 4; i++)
                save[i].start();
        }
        else
            saveStudent(r);
    }
    public synchronized void saveStudent(StudentRequest... r){
        List<Student> students = new ArrayList<>();
        for(StudentRequest request: r){
            String level = request.getLevel();
            List<Course> courses = cRepo.findByLevelStartsWithIgnoreCase(level);
            Optional<CourseAdvisor> advisor = repo.findByLevel(level);
            CourseAdvisor courseAdvisor;
            if (advisor.isEmpty()) {
                var student = Student.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .level(level)
                        .build();
                System.out.println("number of courses =  " + courses.size());
                student.setCourses(new HashSet<>(courses));
                sRepo.save(student);
            }
            else {
                var student = Student.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .level(level)
                        .courseAdvisor(advisor.get())
                        .build();
                System.out.println("number of courses =  " + courses.size());
                student.setCourses(new HashSet<>(courses));
                sRepo.save(student);
            }
        }
    }
    public void update(String courseId, Map<String, Object> request) {
        long id = Long.parseLong(courseId);
        Student toUpdate = sRepo.findById(id).stream().findFirst().orElseThrow(ResourceNotFoundException::new);
        request.forEach((key, value) -> {
            switch (key){
                case "firstname": toUpdate.setFirstname((String) value);
                case "lastname": toUpdate.setLastname((String) value);
                case "level": {
                    toUpdate.setLevel((String) value);
                    toUpdate.setCourses(cRepo.findByLevel((String) value));
                }
                case "email": toUpdate.setEmail((String) value);

            }
        });
    }

    public List<Student> getAll() {
        return sRepo.findAll();
    }

    public Map<DayOfWeek, List<String>> getStudentSchedule(String studentId) {
        long id = Long.parseLong(studentId);
        Map<DayOfWeek, List<String>> studentSchedule = new HashMap<>();
        studentSchedule.put(DayOfWeek.MONDAY, new ArrayList<String>());
        studentSchedule.put(DayOfWeek.TUESDAY, new ArrayList<String>());
        studentSchedule.put(DayOfWeek.WEDNESDAY, new ArrayList<String>());
        studentSchedule.put(DayOfWeek.THURSDAY, new ArrayList<String>());
        studentSchedule.put(DayOfWeek.FRIDAY, new ArrayList<String>());
        studentSchedule.put(DayOfWeek.SATURDAY, new ArrayList<String>());
        Student student = sRepo.findById(id).stream().findFirst().orElseThrow(ResourceNotFoundException::new);
        Set<Course> courses = student.getCourses();
        courses.forEach(c -> {
            List<DayOfWeek> days = new ArrayList<>();
            days = c.getLectureDays();
            days.forEach(day -> {
                switch (day) {
                    case MONDAY, TUESDAY,  WEDNESDAY, THURSDAY, FRIDAY, SATURDAY ->
                            studentSchedule.get(day).add(c.getCourseName());
                }
            });
        });
        return studentSchedule;
    }

    public Set<Course> getStudentCourses(String studentId) {
        long id = Long.parseLong(studentId);
        Student s = sRepo.findById(id).stream().findFirst().orElseThrow();
        return s.getCourses();
    }

    public Student getStudentById(String studentId) throws StudentNotFoundException {
        long id = Long.parseLong(studentId);
        return sRepo.findById(id).
                stream().
                findFirst().
                orElseThrow(() -> new StudentNotFoundException("Student with id as " + id + " does not exist!"));
    }

    public CourseAdvisor getStudentCourseAdvisor(String studentId) {
        long id = Long.parseLong(studentId);
        return sRepo.findById(id)
                .stream().findFirst()
                .orElseThrow(StudentNotFoundException::new)
                .getCourseAdvisor();
    }
}