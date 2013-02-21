package com.db.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 19.02.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "FOLDERS")
public class Folder {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Letter> letters;
    //☺
    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}