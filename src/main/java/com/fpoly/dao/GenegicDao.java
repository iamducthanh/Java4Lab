package com.fpoly.dao;

public interface GenegicDao<T> {
    void insert(T entity);
    void update(T entity);
    void remove(T entity);
}
