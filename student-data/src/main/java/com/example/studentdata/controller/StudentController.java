package com.example.studentdata.controller;

import com.example.studentdata.model.Student;
import com.example.studentdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class StudentController {
    private static final String NAME = "hello world....!";

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     *
     * @return : List of Student
     */
    @RequestMapping("getAllData")
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

    /**
     *
     * @param student : student
     * @return : Save and return student
     */
    @PostMapping("save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    /**
     *
     * @return : Name
     */
    @RequestMapping("name")
    public String getName(){
        return NAME;
    }
}
