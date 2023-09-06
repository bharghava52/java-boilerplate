package com.bharghava.javaboilerplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharghava.javaboilerplate.entity.Student;
import com.bharghava.javaboilerplate.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return addStudent(student);
    }

    public Student getById(int id){
        return studentRepository.getReferenceById(id);
    }

    public boolean deleteStudent(Student student) {
        studentRepository.delete(student);
        return true;
    }
}
