package com.example.documentdata.repository;

import com.example.documentdata.model.DocumentPath;
import org.springframework.data.repository.CrudRepository;

/**
 * Mysql Repository
 */
public interface DocumentRepository extends CrudRepository<DocumentPath, Integer> {
}
