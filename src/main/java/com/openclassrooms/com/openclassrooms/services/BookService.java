package com.openclassrooms.com.openclassrooms.services;


import com.openclassrooms.biblioback.ws.Book;
import com.openclassrooms.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

   @Autowired
   private BookRepository bookRepository;

   public void addBook(Book book) {
       bookRepository.save(book);
   }

   public List<Book> getAllBooks(){
       List<Book> books = new ArrayList<>();
       bookRepository.findAll().forEach(books::add);
       return books;
   }
}
