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
    public void excute(T entity, String method) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            if (method.equals("insert")) {
                em.persist(entity);
            } else if (method.equals("update")) {
                em.merge(entity);
            } else if (method.equals("remove")) {
                em.remove(entity);
            }
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
