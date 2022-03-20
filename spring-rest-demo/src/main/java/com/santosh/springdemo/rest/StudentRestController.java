package com.santosh.springdemo.rest;

import com.santosh.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once!

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Santosh","Varma"));
        theStudents.add(new Student("Tarun","Pinnem"));
        theStudents.add(new Student("Aashish","Musale"));

    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into the list ... keep it simple for now

        // check the studendId against list size
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }

        return theStudents.get(studentId);
    }


}
