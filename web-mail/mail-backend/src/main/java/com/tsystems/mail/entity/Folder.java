package com.tsystems.mail.entity;

import javax.persistence.*;
import java.util.List;


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
            orphanRemoval = true)
    private List<Letter> letters;

    //    fetch = FetchType.EAGER,
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
