//package org.flexicode.web.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "student_courses")
//public class StudentCourse {
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        @ManyToOne
//        @JoinColumn(name = "course_id", referencedColumnName = "id")
//        private Course course;
//
//        @ManyToOne
//        @JoinColumn(name = "student_id", referencedColumnName = "student_id")
//        private Student student;
//}
