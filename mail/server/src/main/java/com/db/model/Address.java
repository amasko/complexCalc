package com.db.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 19.02.13
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ADDR"}),
        name = "ADDRESS")

public class Address {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Column(name = "ADDR", nullable = false)
    protected String addr;

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

    @Column(name = "CREATION_DATE", nullable = false)
    protected String creationDate;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL,
             orphanRemoval = true)
    protected List<Folder> folders;

//    fetch = FetchType.LAZY,

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getAddr() {
        return addr;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return addr +" "+ password +" "+ creationDate + " "+id;
    }
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address that = (Address) o;

        if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return addr != null ? addr.hashCode() : 0;
    }  */
}
