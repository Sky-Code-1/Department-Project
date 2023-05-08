package org.flexicode.web.entity;

import java.sql.Time;
import java.time.DayOfWeek;

public class LectureDetails {
    private DayOfWeek lectureDay;
    private int lectureDuration;
    private Lecturer lecturer;
    private Time lectureStartTime;
    private Time lectureEndTime;
}
