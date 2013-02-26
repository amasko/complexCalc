
package com.db.managers.impl;

import com.db.JPAUtil;
import com.db.managers.UserManager;
import com.db.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserManagerImpl implements UserManager {

    private static final UserManagerImpl instance = new UserManagerImpl();

    private UserManagerImpl() {

    }

    @Override
    public void create(User user) {

        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        em.close();
    }

    public static UserManagerImpl getInstance() {
        return instance;
    }
}