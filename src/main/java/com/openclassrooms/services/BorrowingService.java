package com.openclassrooms.services;

import com.openclassrooms.entities.Borrowing;
import com.openclassrooms.repositories.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService implements IBorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;

    @Override
    public void newBorrowing(Borrowing borrowing) {
        if(borrowingRepository.findById(borrowing.getId()) == null )
            borrowingRepository.save(borrowing);
        else
            System.out.println("L'emprunt existe déjà");
    }

    @Override
    public void updateBorrowing() {

    }

    @Override
    public void stopBorrowing() {

    }

    @Override
    public List<Borrowing> borrowingReport() {
        List<Borrowing> borrowings = new ArrayList<>();
        borrowingRepository.findAll().forEach(borrowings::add);
        return borrowings;
    }
}
