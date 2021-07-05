package com.fpoly.service.impl;

import com.fpoly.dao.impl.UserDao;
import com.fpoly.entity.UserEntity;
import com.fpoly.service.IUserService;

public class UserService implements IUserService {

    @Override
    public void insertUser(UserEntity userEntity) {
        new UserDao().insertUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        new UserDao().updateUser(userEntity);
    }

    @Override
    public void removeUser(int id) {
        new UserDao().removeUser(id);
    }
}
