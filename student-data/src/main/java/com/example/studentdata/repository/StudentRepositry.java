package com.example.studentdata.repository;

import com.example.studentdata.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Mongo Repository
 */
public interface StudentRepositry extends MongoRepository<Student, Integer> {
 }