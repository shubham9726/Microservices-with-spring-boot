package com.example.studentdata.service.impl;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.StudentRepositry;
import com.example.studentdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Student Service Implementation
 */
@Repository
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositry studentRepositry;
    @Autowired
    private RestTemplate restTemplate;


    /**
     *
     * @return : Return List of Student
     */
    @Override
    public List getAll() {
        return studentRepositry.getAll();
    }

    /**
     *
     * @param student : student
     * @return : Return Student data
     */
    @Override
    public Student save(Student student) {
        return studentRepositry.save(student);
    }

    /**
     *
     * @param id : id
     * @return : Return student Data
     * @throws Exception
     */
    @Override
    public Student getStudentById(String id) throws Exception { ;
        Student student= studentRepositry.findById(id);
        if(Objects.isNull(student)) {
            throw new Exception("Student Not Found" +id);
        }
        List<Student> document = restTemplate.getForObject("http://document-service/getAllDocument/",List.class);
        student.setDocumentId(Collections.singletonList(document));
        studentRepositry.update(student);
        return student;
    }

}
