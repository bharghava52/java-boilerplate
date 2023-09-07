package com.bharghava.javaboilerplate.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bharghava.javaboilerplate.entity.Student;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void addStudentTets() {
        Student student = new Student(1,"bharghava","raja");
        Student savedStudent = studentRepository.save(student);
        Assertions.assertNotNull(savedStudent);
        Assertions.assertEquals(student.getId(), savedStudent.getId());
    }
}
