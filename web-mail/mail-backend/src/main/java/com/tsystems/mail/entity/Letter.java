package com.tsystems.mail.entity;

//import com.MailBox;

import javax.persistence.*;

@Entity
@Table(name = "LETTERS")
public class Letter {

    public Letter() {

    }

//    public Letter(MailBox mail) {
//        id = mail.getId();
//        fromAddr = mail.getFrom();
//        toAddr = mail.getTo();
//        created = mail.getCreated();
//        theme = mail.getTheme();
//        body = mail.getBody();
//    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "FOLDER_ID")
    protected Folder folder;

    @Column(name = "FROMADDR")
    protected String fromAddr;

    @Column(name = "TOADDR")
    protected String toAddr;

    @Column(name = "CREATED")
    protected String created;

    @Column(name = "THEME")
    protected String theme;

    @Column(name = "LETTERBODY")
    protected String body;

    public Long getId() {
        return id;
    }

    public Folder getFolder() {
        return folder;
    }

    public String getFromAddr() {
        return fromAddr;
    }

    public String getToAddr() {
        return toAddr;
    }

    public String getCreated() {
        return created;
    }

    public String getTheme() {
        return theme;
    }

    public String getBody() {
        return body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public void setFromAddr(String fromAddr) {
        this.fromAddr = fromAddr;
    }

    public void setToAddr(String toAddr) {
        this.toAddr = toAddr;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public MailBox returnMailBox() {
//
//        MailBox mailbox = new MailBox(id,created,theme,body,fromAddr,toAddr);
//        return mailbox;
//    }

    @Override
    public String toString() {
        return id+"; ";
    }
}

