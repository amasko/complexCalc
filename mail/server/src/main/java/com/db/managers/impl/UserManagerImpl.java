
package com.db.managers.impl;

import com.db.JPAUtil;
import com.db.managers.UserManager;
import com.db.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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