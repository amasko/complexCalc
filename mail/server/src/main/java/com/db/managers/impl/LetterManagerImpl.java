package com.db.managers.impl;

import com.db.JPAUtil;
import com.db.managers.LetterManager;

import com.db.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * User: Alex
 * Date: 26.02.13
 */
public class LetterManagerImpl implements LetterManager{

    private static LetterManagerImpl instance = new LetterManagerImpl();


    private LetterManagerImpl() {

    }

    @Override
    public void storeLetter(Letter letter) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(letter);
        transaction.commit();
    }

    @Override
    public List<Letter> getLettersByFolder(String accName, String folderName) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Address> ca = cb.createQuery(Address.class);
        Root<Address> addressRoot = ca.from(Address.class);
        ca.where(cb.equal(addressRoot.get(Address_.addr),accName));
        Address address = null;
        try {
            address = em.createQuery(ca).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return  Collections.emptyList();
        }

        CriteriaQuery<Folder> cf = cb.createQuery(Folder.class);
        Root<Folder> folderRoot = cf.from(Folder.class);
        cf.where(cb.and(cb.equal(folderRoot.get(Folder_.address), address),
                cb.equal(folderRoot.get(Folder_.name), folderName)));

        Folder folder = null;
        try {
            folder = em.createQuery(cf).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return Collections.emptyList();
        }

        CriteriaQuery<Letter> c = cb.createQuery(Letter.class);
        Root<Letter> letterRoot = c.from(Letter.class);

        c.where(cb.and(
                cb.equal(letterRoot.get(Letter_.folder), folder),
                cb.equal(letterRoot.get(Letter_.fromAddr), accName)));

        List<Letter> letterList = em.createQuery(c).getResultList();

        transaction.commit();
        return (!letterList.isEmpty()) ? letterList :  null;
    }

    public static LetterManagerImpl getInstance() {
        return instance;
    }
}
