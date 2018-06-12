package com.openclassrooms;

import com.openclassrooms.biblioback.ws.Book;
import com.openclassrooms.entities.BookEntity;
import com.openclassrooms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner{

    @Autowired
    BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        BookEntity b1 = new BookEntity("La Peste", "Camus", "Albert");
        BookEntity b2 = new BookEntity("L'Ecume des jours", "Vian", "Boris");
        BookEntity b3 = new BookEntity("L'assomoir", "Zola", "Emile");

        bookService.addBook(b1);
        bookService.addBook(b2);
        bookService.addBook(b3);

        System.out.println("Quelques données ont été entrées!");
    }
}
