package com.openclassrooms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String authorName;
    private String authorFirstName;

    public BookEntity(String title, String authorName, String authorFirstName) {
        this.title = title;
        this.authorName = authorName;
        this.authorFirstName = authorFirstName;
    }

    public BookEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }
}
