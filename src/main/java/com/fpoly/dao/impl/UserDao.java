package com.fpoly.dao.impl;

import com.fpoly.constant.MethodConstant;
import com.fpoly.dao.IUserDao;
import com.fpoly.entity.UserEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao extends AbstractDao<UserEntity> implements IUserDao {

    @Override
    public void insertUser(UserEntity userEntity) {
        excuteUpdate(userEntity, MethodConstant.INSERT);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        excuteUpdate(userEntity, MethodConstant.UPDATE);
    }

    @Override
    public void removeUser(int id) {
        UserEntity userEntity = findById(id);
        excuteUpdate(userEntity, MethodConstant.DELETE);
    }

    @Override
    public List<UserEntity> findAll() {
        String jpql = "SELECT o FROM UserEntity o";
        TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
        List<UserEntity> list = query.getResultList();
        return list;
    }

    @Override
    public UserEntity findById(int id){
        UserEntity userEntity = em.find(UserEntity.class, id);
        return userEntity;
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        String jpql = "SELECT o FROM UserEntity o WHERE o.username = ?1 and o.password = ?2";
        List<UserEntity> list = excuteQuery(jpql, UserEntity.class, username, password);
        return list.isEmpty() ? null : list.get(0);
    }

//    @Override
//    public List<UserEntity> findByPage(int firstPage, int maxResult, Class<UserEntity> userEntityClass) {
//        String jpql = "SELECT o FROM UserEntity o";
//        TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
//        query.setFirstResult(firstPage);
//        query.setMaxResults(maxResult);
//        return query.getResultList();
//    }


}
