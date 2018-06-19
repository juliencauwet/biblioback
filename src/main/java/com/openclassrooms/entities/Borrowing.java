package com.openclassrooms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Borrowing {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private AppUser appUser;

    @ManyToOne(cascade = CascadeType.ALL)
    private BookEntity bookEntity;
    @NotNull
    private Date startDate;
    private Date returnDate;
    private Date extensionDate;
    private Boolean isExtended = false;

    public Borrowing() {
    }

    public Borrowing(AppUser appUser, BookEntity bookEntity, Date startDate) {
        this.appUser = appUser;
        this.bookEntity = bookEntity;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getBackDate() {
        return returnDate;
    }

    public void setBackDate(Date backDate) {
        this.returnDate = backDate;
    }

    public Date getExtensionDate() {
        return extensionDate;
    }

    public void setExtensionDate(Date extensionDate) {
        this.extensionDate = extensionDate;
    }

    public Boolean getExtended() {
        return isExtended;
    }

    public void setExtended(Boolean extended) {
        isExtended = extended;
    }

    /**
     *
     * @param startDate
     * @param isExtended
     * @return
     */
    public Date dueReturnDate(Date startDate, Boolean isExtended){
        Date returnDate = new Date();

        return returnDate;
    }
}
