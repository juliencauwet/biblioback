package com.openclassrooms.services;

import com.openclassrooms.entities.BookEntity;
import com.openclassrooms.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

   @Autowired
   private BookRepository bookRepository;

   public void addBook(BookEntity bookEntity) {
       bookRepository.save(bookEntity);
   }

   public List<BookEntity> getAllBooks(){
       List<BookEntity> bookEntities = new ArrayList<>();
       bookRepository.findAll().forEach(bookEntities::add);
       return bookEntities;
   }

    public BookEntity getBookByTitle(String title){
       return bookRepository.findBookEntityByTitle(title);
    }
}
