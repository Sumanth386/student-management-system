package com.sumanth.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumanth.student_management_system.entity.Student;
import com.sumanth.student_management_system.exception.StudentNotFoundException;
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

        System.out.println("Inside getStudentById");

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
    }
    
    public Student updateStudent(Integer id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());

        return studentRepository.save(existingStudent);
    }
    
    public String deleteStudent(Integer id) {
    	studentRepository.deleteById(id);
    	return "Student deleted successfully";
    }
}
