package com.example.studentdata.controller;

import com.example.studentdata.model.Student;
import com.example.studentdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Student Rest Controller
 */
@RestController
@RequestMapping("/")
public class StudentController {
    private static final String NAME = "hello world....!";

    @Autowired
    private StudentService studentService;

    /**
     *
     * @return : List of Student
     */
    @RequestMapping("/getAllData")
    public List getAll() {
        return studentService.getAll();
    }

    /**
     *
     * @param student : student
     * @return : Save and return student
     */
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    /**
     *
     * @return : Name
     */
    @RequestMapping("/name")
    public String getName(){
        return NAME;
    }

    /**
     *
     * @param id : id
     * @return : Save List of Document Ids and Return Student Data
     * @throws Exception
     */
    @PostMapping("/getDocumentId")
    public Student getDocumentId(@RequestParam String id) throws Exception {
         return studentService.getStudentById(id);
    }
}
