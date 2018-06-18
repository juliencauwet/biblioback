package com.openclassrooms;

import com.openclassrooms.biblioback.ws.Book;
import com.openclassrooms.entities.AppUser;
import com.openclassrooms.entities.BookEntity;
import com.openclassrooms.entities.Borrowing;
import com.openclassrooms.services.AppUserService;
import com.openclassrooms.services.BookService;
import com.openclassrooms.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CLR implements CommandLineRunner{

    @Autowired
    BookService bookService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    BorrowingService borrowingService;

    @Override
    public void run(String... args) throws Exception {
        BookEntity b1 = new BookEntity("La Peste", "Camus", "Albert");
        BookEntity b2 = new BookEntity("L'Ecume des jours", "Vian", "Boris");
        BookEntity b3 = new BookEntity("L'assomoir", "Zola", "Emile");
        BookEntity b4 = new BookEntity("Les Confessions", "Rousseau", "Jean-Jacques");
        BookEntity b5 = new BookEntity("Candide", "Voltaire", "");
        BookEntity b6 = new BookEntity("Jean de Florette", "Pagnol", "Marcel");

        bookService.addBook(b1);
        bookService.addBook(b2);
        bookService.addBook(b3);
        bookService.addBook(b4);
        bookService.addBook(b5);
        bookService.addBook(b6);

        AppUser u1 = new AppUser("Julien", "Cauwet", "juliencauwet@yahoo.fr", "12345", true);
        AppUser u2 = new AppUser("Juan", "Olivero", "jjolivero83@gmail.com", "abcde", false);
        AppUser u3 = new AppUser("Manu", "Favre", "emmfavvic@gmail.com", "vwxyz", false);
        AppUser u4 = new AppUser("Laëtitia", "Cauwet", "laetis0609@yahoo.fr", "98765", false);

        appUserService.addUser(u1);
        appUserService.addUser(u2);
        appUserService.addUser(u3);
        appUserService.addUser(u4);

        Borrowing bor1 = new Borrowing(u1, b3, new Date());
        Borrowing bor2 = new Borrowing(u4, b6, new Date());
        Borrowing bor3 = new Borrowing(u2, b2, new Date());
        Borrowing bor4 = new Borrowing(u3, b1, new Date());



        System.out.println("Quelques données ont été entrées!");
    }
}
