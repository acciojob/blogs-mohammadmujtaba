package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String username;

    @Column(name = "password",unique = true)
    String password;

    String firstname;

    String lastname;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> blogs = new ArrayList<>();

    public User(Integer id, String username, String password, String firstname, String lastname, List<Blog> blogs) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.blogs = blogs;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Blog> getBlogList() {
        return blogs;
    }

    public void setBlogList(List<Blog> blogs) {
        this.blogs = blogs;
    }
}