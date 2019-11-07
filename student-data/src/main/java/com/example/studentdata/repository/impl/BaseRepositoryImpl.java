package com.example.studentdata.repository.impl;

import com.example.studentdata.model.IdentityModel;
import com.example.studentdata.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * BaseRepository Implementation
 * @param <E>
 */
public class BaseRepositoryImpl<E extends IdentityModel> implements BaseRepository<E> {

    @Autowired
    protected MongoTemplate mongoTemplate;
    private Class<E> eClass;

    protected BaseRepositoryImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        eClass = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<E> getAll() {
        return mongoTemplate
                .find(new Query(Criteria.where("deleted")
                                .is(Boolean.FALSE)),
                        eClass);
    }

    @Override
    public E save(E object) {
        mongoTemplate.insert(object);
        return object;
    }

    @Override
    public E findById(String id) {
        return mongoTemplate
                .findOne(new Query(Criteria.where("_id").is(id)), eClass);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public E update(E e) {
        mongoTemplate.save(e);
        return e;
    }
}
