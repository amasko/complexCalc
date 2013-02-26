package com.db.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Letter.class)
public class Letter_ {

    public static volatile SingularAttribute<Letter, Long> id;
    public static volatile SingularAttribute<Letter, Folder> folder;
    public static volatile SingularAttribute<Letter, String> fromAddr;
    public static volatile SingularAttribute<Letter, String> toAddr;
    public static volatile SingularAttribute<Letter, String> created;
    public static volatile SingularAttribute<Letter, String> theme;
    public static volatile SingularAttribute<Letter, String> body;
}

