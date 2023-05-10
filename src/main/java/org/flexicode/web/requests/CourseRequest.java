package org.flexicode.web.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private List<DayOfWeek> lectureDays;
    private String courseName;
    private String courseCode;
    private String level;
    private int courseCredit;

}
