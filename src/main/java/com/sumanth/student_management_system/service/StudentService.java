package com.sumanth.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumanth.student_management_system.entity.Student;
import com.sumanth.student_management_system.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }
    
    public Student getStudentById(Integer id) {

        Optional<Student> student = studentRepository.findById(id);

        return student.orElse(null);
    }
}
