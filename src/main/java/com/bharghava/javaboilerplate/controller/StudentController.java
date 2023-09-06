package com.bharghava.javaboilerplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharghava.javaboilerplate.entity.Student;
import com.bharghava.javaboilerplate.model.ResponseData;
import com.bharghava.javaboilerplate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<ResponseData> getAllStudents() {
        return new ResponseEntity<ResponseData>(
            new ResponseData(studentService.getAllStudents()), null, 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getbyStudentId(@Param(value = "id") int id) {
        return new ResponseEntity<ResponseData>(
            new ResponseData(studentService.getById(id)), null, 200);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseData> addStudent(@RequestBody Student student){
        return new ResponseEntity<ResponseData>(
            new ResponseData(studentService.addStudent(student)), null, 200);
    }
}
