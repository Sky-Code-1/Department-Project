package org.flexicode.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
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
    @Column(unique = true, nullable = false)
    private String email;
    private boolean hasPost;
    @ManyToMany(cascade=CascadeType.DETACH)
    @JoinTable(name = "lecturer_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();
}
