package com.bharghava.javaboilerplate.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bharghava.javaboilerplate.entity.Student;
import com.bharghava.javaboilerplate.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;
    
    @Test
    void addStudentTest() {
        Student student = new Student(1, "bharghava", "raja");
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);
        Student studentAssert  = studentService.addStudent(student);
        Assertions.assertEquals(student.getId(), studentAssert.getId());
    }
}
