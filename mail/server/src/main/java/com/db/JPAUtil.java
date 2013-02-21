package com.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 20.02.13
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
