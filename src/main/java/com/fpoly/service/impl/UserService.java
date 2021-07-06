package com.fpoly.service.impl;

import com.fpoly.dao.impl.UserDao;
import com.fpoly.entity.UserEntity;
import com.fpoly.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {
    @Inject private UserDao userDao;

    @Override
    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<UserEntity> findByKeyword(String keyword) {
        return userDao.findByKeyword(keyword);
    }

    @Override
    public List<UserEntity> findByPage(int page, int size) {
        return userDao.findByPage(page, size);
    }

    @Override
    public List<UserEntity> findByRole(int role) {
        return userDao.findByRole(role);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userDao.findById(id);
    }
}
