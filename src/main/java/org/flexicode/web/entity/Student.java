package org.flexicode.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "student_seq")
    @Column(name = "student_id")
    private Long studentId;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_advisor")
    @JsonIgnore
    private CourseAdvisor courseAdvisor;
    @ManyToMany(cascade=CascadeType.DETACH)
    @JoinTable(name = "student_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();
    @Column(nullable = false, unique = true)
    private String email;
}
