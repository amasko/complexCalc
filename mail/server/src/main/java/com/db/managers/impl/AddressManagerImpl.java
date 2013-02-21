package com.db.managers.impl;

import com.db.JPAUtil;
import com.db.managers.AddressManager;
import com.db.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 21.02.13
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
public class AddressManagerImpl implements AddressManager {
    private static AddressManagerImpl instance = new AddressManagerImpl();

    @Override
    public void create(Address address) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(address);
        transaction.commit();
        em.close();

    }

    public static AddressManagerImpl getInstance() {
        return instance;
    }


}
