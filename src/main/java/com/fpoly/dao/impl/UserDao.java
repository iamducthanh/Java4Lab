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
        List<UserEntity> list = excuteQuery("findAll", UserEntity.class);
        return list;
    }

    @Override
    public UserEntity findById(int id){
        UserEntity userEntity = em.find(UserEntity.class, id);
        return userEntity;
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        List<UserEntity> list = excuteQuery("findByUsernameAndPassword", UserEntity.class, username, password);
        return list.isEmpty() ? null : list.get(0);
    }

    public List<UserEntity> findByPage(int page, int size) {
        String jpql = "SELECT o FROM UserEntity o";
        TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> findByKeyword(String keyword){
        List<UserEntity> list = excuteQuery("findByKeyword", UserEntity.class, keyword);
        return list;
    }

    @Override
    public List<UserEntity> findByRole(int role) {
        List<UserEntity> list = excuteQuery("findByRole", UserEntity.class, role);
        return list;
    }

    @Override
    public UserEntity findByUsername(String username) {
        List<UserEntity> list = excuteQuery("findByUsername", UserEntity.class, username);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public UserEntity findByUsernameAndId(String username, int id) {
        List<UserEntity> list = excuteQuery("findByUsernameAndId", UserEntity.class, username, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public UserEntity findByEmail(String email) {
        List<UserEntity> list = excuteQuery("findByEmail", UserEntity.class, email);
        return list.isEmpty() ? null : list.get(0);
    }


}
