package com.fpoly.dao;

import com.fpoly.entity.UserEntity;

public interface IUserDao extends GenegicDao<UserEntity>{
    void insertUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void removeUser(int id);
}
