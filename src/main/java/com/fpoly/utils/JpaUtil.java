package com.fpoly.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    public static JpaUtil jpaUtil;

    public static JpaUtil getJpaUtil(){
        if (jpaUtil == null){
            return jpaUtil = new JpaUtil();
        } else {
            return jpaUtil;
        }
    }

    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("polyoe");
        return emf.createEntityManager();
    }


}
