package com.openclassrooms.services;

import com.openclassrooms.entities.Borrowing;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBorrowingService {

    void newBorrowing(Borrowing borrowing);
    void updateBorrowing();
    void stopBorrowing();
    List<Borrowing> borrowingReport();

}
