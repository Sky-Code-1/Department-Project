package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Lecturer {
    @Id
    @SequenceGenerator(name = "lecturer_seq", sequenceName = "lecturer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_seq")
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(unique = true)
    private Post position;
    @Enumerated(value = EnumType.STRING)
    private Title title;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private boolean hasPost;
    @ManyToMany
    private Set<Course> courses = new HashSet<>();
//    public void addCourses(Set<Course> course){
//        this.courses.addAll((course));
//    }
}
