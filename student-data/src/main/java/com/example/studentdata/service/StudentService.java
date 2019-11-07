package com.example.studentdata.service;

import com.example.studentdata.model.Student;

import java.util.List;

public interface StudentService {

    List getAll();

    Student save(Student student);

    Student getStudentById(String id) throws Exception;
}
