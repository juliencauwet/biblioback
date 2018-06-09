package com.openclassrooms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Borrowing {

    @Id
    @GeneratedValue
    private int id;


}
