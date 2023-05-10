package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseAdvisor {
    @Id
    @SequenceGenerator(name = "advisor_seq", sequenceName = "advisor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "advisor_seq")
    private Long id;
    @Column(nullable = false, unique = true)
    private String level;
    @OneToOne
    private Lecturer advisor;
    @OneToMany(mappedBy = "courseAdvisor")
    private List<Student> students;
}