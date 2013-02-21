package com.db.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13.02.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "user")
    private Address address;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @Column(name = "PHONE_NUMBER")
    private String phone;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {

        return phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}