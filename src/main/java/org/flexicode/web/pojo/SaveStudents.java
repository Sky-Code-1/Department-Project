package org.flexicode.web.pojo;

import org.flexicode.web.requests.StudentRequest;
import org.flexicode.web.service.StudentService;

public class SaveStudents extends Thread {
    private final StudentService service;
    private static int threadNumber;
    private final StudentRequest [] students;
    public SaveStudents(StudentService service, StudentRequest... students){
        this.service = service;
        this.students = students;
        System.out.println("Creating Thread no " + threadNumber);
        threadNumber++;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        this.saveStudents();
        System.out.println("completed in " + (System.currentTimeMillis() - startTime)/1000 + "s");
    }


    public void saveStudents(){
        service.saveStudent(students);
    }
}
