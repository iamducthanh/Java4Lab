package com.fpoly.dao.impl;

import com.fpoly.constant.MethodConstant;
import com.fpoly.dao.IUserDao;
import com.fpoly.entity.UserEntity;

public class UserDao extends AbstractDao<UserEntity> implements IUserDao {
    @Override
    public void insertUser(UserEntity userEntity) {
        excute(userEntity, MethodConstant.INSERT);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        excute(userEntity, MethodConstant.UPDATE);
    }

    @Override
    public void removeUser(int id) {
        UserEntity userEntity = findById(id);
        excute(userEntity, MethodConstant.DELETE);
    }

    public UserEntity findById(int id){
        UserEntity userEntity = em.find(UserEntity.class, id);
        return userEntity;
    }
}
