package com.db.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * User: Alex
 * Date: 26.02.13
 */
@StaticMetamodel(Folder.class)
public class Folder_ {

    public static volatile SingularAttribute<Folder, Long> id;
    public static volatile SingularAttribute<Folder, String> name;
    public static volatile SingularAttribute<Folder, String> address;
}
