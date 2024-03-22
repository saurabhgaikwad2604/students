package com.example.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.students.model.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
    
}
