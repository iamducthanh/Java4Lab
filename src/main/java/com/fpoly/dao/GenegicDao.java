package com.fpoly.dao;

import com.fpoly.dao.impl.UserDao;

import java.util.List;

public interface GenegicDao<T> {
    int excuteUpdate(T entity, String method);
    List<T> excuteQuery(String nameQuery, Class<T> aClass, Object... parameters);
    List<T> excuteQuery2(String jpql, Class<T> aClass, Object... parameters);

}
