package org.flexicode.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseAdvisor {
    @Id
    @SequenceGenerator(name = "advisor_seq", sequenceName = "advisor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "advisor_seq")
    private Long id;
    @Column(nullable = false, unique = true)
    private String level;
    @OneToOne
    @JoinColumn(name = "advisor_id")
    private Lecturer advisor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseAdvisor")
    @JsonIgnore
    private List<Student> students;
    @Column(unique = true, nullable = false)
    private String email;
}