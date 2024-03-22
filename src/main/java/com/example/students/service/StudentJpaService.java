package com.example.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.students.model.Student;
import com.example.students.repository.StudentJpaRepository;
import com.example.students.repository.StudentRepository;

@Service
public class StudentJpaService implements StudentRepository {
    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Override
    public List<Student> getStudents() {
        List<Student> students = studentJpaRepository.findAll();
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        try{
            Student student = studentJpaRepository.findById(id).get();
            return student;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Student addStudent(Student student) {
        studentJpaRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(int id, Student student) {
        try{
            Student newStudent = studentJpaRepository.findById(id).get();
            if(student.getName() != null){
                newStudent.setName(student.getName());
            }
            if(student.getAge() != 0){
                newStudent.setAge(student.getAge());
            }
            if(student.getPrn() != 0){
                newStudent.setPrn(student.getPrn());
            }
            if(student.getClassName() != null){
                newStudent.setClassName(student.getClassName());
            }
            if(student.getDivision() != null){
                newStudent.setDivision(student.getDivision());
            }
            studentJpaRepository.save(newStudent);
            return newStudent;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteStudent(int id) {
        try{
            studentJpaRepository.deleteById(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    
}
