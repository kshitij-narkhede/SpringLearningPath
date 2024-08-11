package com.knark.restdemo.rest;

import com.knark.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents ;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Knark","Nark"));
        theStudents.add(new Student("Jack","Jackey"));
        theStudents.add(new Student("Kim","Kimmy"));
    }

    @GetMapping("/student")
    public List<Student> getStudents() {

        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {

        if((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException(("Student id not found--")+studentId);
        }
      return theStudents.get(studentId);
    }

    // Add an exception handler

}



