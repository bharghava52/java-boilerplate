package com.bharghava.javaboilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bharghava.javaboilerplate.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
