package com.example.studentdata.repository;

import com.example.studentdata.model.IdentityModel;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends IdentityModel> extends Serializable {

    List<E> getAll();
    E save(E object);
    E findById(String id);
    void delete(String id);
    E update(E e);
}
