package com.example.studentdata.service.impl;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.StudentRepositry;
import com.example.studentdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Component
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepositry studentRepositry;

    @Autowired
    public StudentServiceImpl(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    @Override
    public Collection<Student> getAll() {
        return studentRepositry.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepositry.save(student);
    }
}
