package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    String content;

    @CreationTimestamp
    Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> images = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setImageList(List<Image> images) {
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public List<Image> getImageList() {
        return images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}