package com.bharghava.javaboilerplate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private int id;

    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
}
