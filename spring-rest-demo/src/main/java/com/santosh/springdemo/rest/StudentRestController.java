package com.santosh.springdemo.rest;

import com.santosh.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Santosh","Varma"));
        theStudents.add(new Student("Tarun","Pinnem"));
        theStudents.add(new Student("Aashish","Musale"));

        return theStudents;
    }
}
