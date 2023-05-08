package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lecturer {
    @Id
    @SequenceGenerator(name = "lecturer_seq", sequenceName = "lecturer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_seq")
    private Long id;
    @Enumerated
    @Column(unique = true)
    private Post position;
    @Enumerated
    private Title title;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @ManyToMany
    private Set<Course> courses = new HashSet<>();
}
