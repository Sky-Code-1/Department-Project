package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Enumerated(value = EnumType.STRING)
    private List<DayOfWeek> lectureDays;
    @ManyToMany
    private Set<Student> students = new HashSet<>();
    @ManyToMany
    private Set<Lecturer> lecturers = new HashSet<>();
    @OneToMany
    private List<LectureDetails> details;
}
