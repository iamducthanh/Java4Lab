package com.fpoly.service;

import com.fpoly.entity.UserEntity;

import java.util.List;

public interface IUserService {
    void insertUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void removeUser(int id);
    UserEntity findByUsernameAndPassword(String username, String password);
    List<UserEntity> findByKeyword(String keyword);
    List<UserEntity> findByPage(int page, int size);
    List<UserEntity> findByRole(int role);
    List<UserEntity> findAll();
    UserEntity findById(int id);
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndId(String username, int id);
}
