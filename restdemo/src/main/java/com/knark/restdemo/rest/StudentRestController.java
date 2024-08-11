package com.knark.restdemo.rest;

import com.knark.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
      return theStudents.get(studentId);
    }
}
