package com.fpoly.service;

import com.fpoly.entity.UserEntity;

public interface IUserService {
    void insertUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void removeUser(int id);
}
