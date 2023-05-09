package org.flexicode.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.DayOfWeek;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LectureDetails {
    @Id
    @SequenceGenerator(name = "details_seq", sequenceName = "details_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "details_seq")
    private Long lectureId;
    private DayOfWeek lectureDay;
    @Column(name = "duration")
    private int lectureDuration;
    @OneToOne
    private Lecturer lecturer;
    @Column(name = "lecture_start")
    private Time lectureStart;
    @Column(name = "lecture_end")
    private Time lectureEnd;

    @ManyToOne
    private Course course;
}
