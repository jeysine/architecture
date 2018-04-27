package cn.com.architecture.service;

import java.io.Serializable;
import java.util.List;

public interface Service<T, ID extends Serializable> {
    void insert(T entity);

    T findById(ID id);

    void delete(ID id);

    List<T> findAll();

    long count();

    boolean exists(ID id);
}
