package com.Heuy.students.Admin.controllers;

import com.Heuy.students.Admin.entites.Student;
import com.Heuy.students.Admin.requests.StudentRegistrationRequest;
import com.Heuy.students.Admin.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("students/v1/")
public record StudentController(StudentService studentService){
    @PostMapping("registerStudent")
    public void registerStudent(@RequestBody StudentRegistrationRequest studentRequest){
        log.info("registering a student{}", studentRequest);
        studentService.registerStudent(studentRequest);
    }

    @GetMapping("getstudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }
}
