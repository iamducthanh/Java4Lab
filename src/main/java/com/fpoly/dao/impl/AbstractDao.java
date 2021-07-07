package com.fpoly.dao.impl;

import com.fpoly.constant.MethodConstant;
import com.fpoly.dao.GenegicDao;
import com.fpoly.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AbstractDao<T> implements GenegicDao<T> {
    public EntityManager em = JpaUtil.getJpaUtil().getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    @Override
    public int excuteUpdate(T entity, String method) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            if (method.equals(MethodConstant.INSERT)) {
                em.persist(entity);
            } else if (method.equals(MethodConstant.UPDATE)) {
                em.merge(entity);
            } else if (method.equals(MethodConstant.DELETE)) {
                em.remove(entity);
            }
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return 0;
        } finally {
            return 1;
        }
    }

    @Override
    public List<T> excuteQuery(String jpql, Class<T> aClass, Object... parameters) {
        TypedQuery<T> query = em.createQuery(jpql, aClass);
        if(parameters != null){
            setParameter(query, parameters);
        }
        List<T> list = query.getResultList();
        return list;
    }

    public void setParameter(TypedQuery<T> query, Object... parameters){
        for(int i = 0; i< parameters.length;i++){
            Object parameter = parameters[i];
            int index = i + 1;
            query.setParameter(index, parameter);
        }
    }

}
