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
            borrowingRepository.save(borrowing);
    }

    @Override
    public void updateBorrowing(Borrowing borrowing) {
        borrowingRepository.save(borrowing);
    }

    @Override
    public List<Borrowing> borrowingReport() {
        List<Borrowing> borrowings = new ArrayList<>();
        borrowingRepository.findAll().forEach(borrowings::add);
        return borrowings;
    }

    @Override
    public Borrowing getById(int id) {
        return borrowingRepository.findById(id);
    }
}
