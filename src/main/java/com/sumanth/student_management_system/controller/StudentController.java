package com.sumanth.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sumanth.student_management_system.entity.Student;
import com.sumanth.student_management_system.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {

        System.out.println("GET BY ID CALLED");

        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        return studentService.deleteStudent(id);
    }
}