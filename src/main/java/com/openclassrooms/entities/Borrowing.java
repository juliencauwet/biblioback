package com.openclassrooms.entities;

import javax.persistence.*;

@Entity
public class Borrowing {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    AppUser appUser;

    @ManyToOne(cascade = CascadeType.ALL)
    BookEntity bookEntity;

    public Borrowing() {
    }

    public Borrowing(AppUser appUser, BookEntity bookEntity) {
        this.appUser = appUser;
        this.bookEntity = bookEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
