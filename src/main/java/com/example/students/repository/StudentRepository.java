package com.example.students.repository;

import com.example.students.model.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> getStudents();
    Student getStudentById(int id);
    Student addStudent(Student student);
    Student updateStudent(int id, Student student);
    void deleteStudent(int id);
}
