package com.fpoly.dao.impl;

import com.fpoly.dao.IUserDao;
import com.fpoly.entity.UserEntity;

public class UserDao extends AbstractDao<UserEntity> implements IUserDao {
    @Override
    public void insertUser(UserEntity userEntity) {
        insert(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        update(userEntity);
    }

    @Override
    public void removeUser(int id) {
        UserEntity userEntity = findById(id);
        remove(userEntity);
    }

    public UserEntity findById(int id){
        UserEntity userEntity = em.find(UserEntity.class, id);
        return userEntity;
    }
}
