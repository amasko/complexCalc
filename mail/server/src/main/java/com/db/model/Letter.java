package com.db.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 19.02.13
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "LETTERS")
public class Letter {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FOLDER_ID")
    private Folder folder;

    @Column(name = "FROMADDR")
    private String fromAddr;

    @Column(name = "TOADDR")
    private String toAddr;

    @Column(name = "CREATED")
    private String created;

    @Column(name = "THEME")
    private String theme;

    @Column(name = "LETTERBODY")
    private String body;

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
}
