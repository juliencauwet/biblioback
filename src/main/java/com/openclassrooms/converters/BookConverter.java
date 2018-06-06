package com.openclassrooms.converters;


import com.openclassrooms.biblioback.ws.Book;
import com.openclassrooms.entities.BookEntity;

public class BookConverter {

    BookEntity bookEntity;
    Book book;

    public Book toDTO(BookEntity b){
        Book bookDTO = new Book();
        bookDTO.setAuthorFirstName(b.getAuthorFirstName());
        bookDTO.setAuthorName(b.getAuthorName());
        bookDTO.setTitle(b.getTitle());
        return bookDTO;
    }

    public BookEntity toEntity(Book b){
        BookEntity book = new BookEntity();
        book.setAuthorFirstName(b.getAuthorFirstName());
        book.setAuthorName(b.getAuthorName());
        book.setTitle(b.getTitle());
        return book;
    }


}
