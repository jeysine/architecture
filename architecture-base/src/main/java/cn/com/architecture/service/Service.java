package cn.com.architecture.service;

import java.io.Serializable;

public interface Service<T, ID extends Serializable> {
    T save(T entity);

    T findById(ID id);

    void delete(ID id);

    Iterable<T> findAll();

    long count();

    boolean exists(ID id);
}
