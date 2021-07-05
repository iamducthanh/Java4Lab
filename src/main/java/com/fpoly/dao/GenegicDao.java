package com.fpoly.dao;

public interface GenegicDao<T> {
    void excute(T entity, String method);
}
