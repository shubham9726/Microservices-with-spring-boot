package com.example.studentdata.service;


import com.example.studentdata.model.Student;

import java.util.Collection;

public interface StudentService {

    Collection<Student> getAll();

    Student save(Student student);
}
