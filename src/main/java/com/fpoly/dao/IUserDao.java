package com.fpoly.dao;

import com.fpoly.entity.UserEntity;

import java.util.List;

public interface IUserDao extends GenegicDao<UserEntity>{
    void insertUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void removeUser(int id);
    List<UserEntity> findAll();
    UserEntity findById(int id);
    UserEntity findByUsernameAndPassword(String username, String password);
    List<UserEntity> findByKeyword(String keyword);
    List<UserEntity> findByRole(int role);
}
