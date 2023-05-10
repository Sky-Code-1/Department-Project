package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Course {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    private Long courseId;
    @Column(nullable = false)
    private String courseName;
    @Column(unique = true, nullable = false)
    private String courseCode;
    @Column(nullable = false)
    private String level;
    @Column(name = "Credit", nullable=false)
    private int courseCredit;
    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(value = EnumType.STRING)
    private List<DayOfWeek> lectureDays;
    @ManyToMany
    private Set<Student> students = new HashSet<>();
    @ManyToMany
    private Set<Lecturer> lecturers = new HashSet<>();
    @OneToMany
    private List<LectureDetails> details;

    public void addStudent(Student student){
        students.add(student);
    }
}
