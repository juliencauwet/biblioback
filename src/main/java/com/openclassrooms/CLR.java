package com.openclassrooms;

import com.openclassrooms.entities.AppUser;
import com.openclassrooms.entities.BookEntity;
import com.openclassrooms.entities.Borrowing;
import com.openclassrooms.services.AppUserService;
import com.openclassrooms.services.BookService;
import com.openclassrooms.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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
        BookEntity b1 = new BookEntity("La Peste", "Camus", "Albert",4);
        BookEntity b2 = new BookEntity("L'Ecume des jours", "Vian", "Boris",1);
        BookEntity b3 = new BookEntity("L'assomoir", "Zola", "Emile",1);
        BookEntity b4 = new BookEntity("Les Confessions", "Rousseau", "Jean-Jacques", 2);
        BookEntity b5 = new BookEntity("Candide", "Voltaire", "", 7);
        BookEntity b6 = new BookEntity("Jean de Florette", "Pagnol", "Marcel", 1);

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

        String strDate1 = "26/05/2018";
        String strDate2 = "27/06/2019";
        String strDate3 = "28/07/2020";
        String strDate4 = "29/08/2021";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date date1 = sdf.parse(strDate1);
        Date date2 = sdf.parse(strDate2);
        Date date3 = sdf.parse(strDate3);
        Date date4 = sdf.parse(strDate4);

        Borrowing bor1 = new Borrowing(u1, b3, date1);
        Borrowing bor2 = new Borrowing(u4, b6, date2);
        Borrowing bor3 = new Borrowing(u2, b2, date3);
        Borrowing bor4 = new Borrowing(u3, b1, date4);
        Borrowing bor5 = new Borrowing(u1, b4, date2);

        borrowingService.newBorrowing(bor1);
        borrowingService.newBorrowing(bor2);
        borrowingService.newBorrowing(bor3);
        borrowingService.newBorrowing(bor4);
        borrowingService.newBorrowing(bor5);

        System.out.println("d1 = " + date1 + " \n" + "d2 = " + date2);

        System.out.println(bookService.getBookById(2).getTitle());
        System.out.println(bookService.getBookById(3).getTitle());
        System.out.println(bookService.getBookById(4));
        System.out.println(bookService.getBookById(1));

        /*
        public int borrow(String start, String end, Topo topo){
        Date startDate = null;
        Date endDate = null;
        Date today = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = sdf.parse(start);
            endDate = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (startDate.after(endDate) || today.after(startDate)) {
            return 1;
        }

        Calendar c0 = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c0.setTime(startDate);
        c1.setTime(endDate);
        c1.add(Calendar.DATE, 1);

        List<Borrowing> borrowing;

        do {

            borrowing = borrowingService.getBorrowing(c0.getTime(), topo.getId());

            if (borrowing.size() > 0 )
                return 2;
            else
                c0.add(Calendar.DATE, 1);
        } while (!c0.equals(c1));

        c0.setTime(startDate);

        do {
            borrowingService.addBorrowing(new Borrowing(topo, c0.getTime()));
            c0.add(Calendar.DATE, 1);
        } while (!c0.equals(c1));

        return 3;

    }
         */

        System.out.println("Quelques données ont été entrées!");
    }
}
