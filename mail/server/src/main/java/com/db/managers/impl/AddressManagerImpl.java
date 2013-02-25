package com.db.managers.impl;

import com.db.JPAUtil;
import com.db.managers.AddressManager;
import com.db.model.Address;
import com.db.model.Address_;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;


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

        address.setPassword(DigestUtils.md5Hex(address.getPassword()));
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(address);
        transaction.commit();
        em.close();
    }

    @Override
    public Address checkAddress(String login, String password) {

        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        String hash = DigestUtils.md5Hex(password);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Address> c = cb.createQuery(Address.class);
        Root<Address> addressRoot = c.from(Address.class);

        c.where(cb.and(
                cb.equal(addressRoot.get(Address_.addr), login + "@mailbox.ru"),
                cb.equal(addressRoot.get(Address_.password), hash)));

        Address ad = null;
        boolean isQuery = true;
        try {
            ad = em.createQuery(c).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            isQuery = false;
        }

        transaction.commit();
        em.close();
        return (isQuery) ? ad : null;
    }

    @Override
    public boolean checkExist(String login) {

        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Address> c = cb.createQuery(Address.class);
        Root<Address> addressRoot = c.from(Address.class);
        c.where(cb.equal(addressRoot.get(Address_.addr), login + "@mailbox.ru"));
        //Address ad = null;
        boolean isQuery = true;
        try {
            em.createQuery(c).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            isQuery = false;
        }

        transaction.commit();
        em.close();
        return isQuery;

    }

    public static AddressManagerImpl getInstance() {
        return instance;
    }
}
