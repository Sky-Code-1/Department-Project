package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "student_seq")
    private Long studentId;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_advisor")
    private CourseAdvisor courseAdvisor;
    @ManyToMany
    private Set<Course> courses = new HashSet<>();

}
