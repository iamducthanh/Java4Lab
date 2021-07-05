package com.fpoly.dao.impl;

import com.fpoly.dao.GenegicDao;
import com.fpoly.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbstractDao<T> implements GenegicDao<T> {
    public EntityManager em = JpaUtil.getJpaUtil().getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    @Override
    public void insert(T entity) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T entity) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void remove(T entity) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(entity);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
