package com.example.students.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private long prn;
    private String className;
    private String division;
}
