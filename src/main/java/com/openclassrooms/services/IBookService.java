package com.openclassrooms.services;

import com.openclassrooms.entities.BookEntity;

import java.util.List;

public interface IBookService {

        List<BookEntity> getAllBooks();
        BookEntity getBookByTitle(String title);
        void addBook(BookEntity bookEntity);

}
