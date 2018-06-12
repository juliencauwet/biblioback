package com.openclassrooms.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String authorName;
    private String authorFirstName;

    @OneToMany
    @JoinColumn(name = "borrowing_id")
    private Set<Borrowing> borrowings = new HashSet<>();

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
