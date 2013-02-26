package com.db.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 24.02.13
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */

@StaticMetamodel (Address.class)
public class Address_ {

    public static volatile SingularAttribute<Address, Long> id;
    public static volatile SingularAttribute<Address, User> user;
    public static volatile SingularAttribute<Address, String> password;
    public static volatile SingularAttribute<Address, String> addr;
    public static volatile SingularAttribute<Address, String> creatioDate;
    public static volatile ListAttribute<Address, Folder> folders;
}
