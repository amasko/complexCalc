package db.model;

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
@UniqueConstraint(columnNames = "LOGIN")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String password;


    @Column(name = "BIRTH_DATE")
    private String birthDate;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}