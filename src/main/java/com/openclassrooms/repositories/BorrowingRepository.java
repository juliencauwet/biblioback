package com.openclassrooms.repositories;

import com.openclassrooms.entities.Borrowing;
import com.openclassrooms.entities.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing,Integer>{

    Borrowing findById(int id);
    List<Borrowing> findAllByAppUserId(int id);
    List<Borrowing> findAllByDueReturnDateBeforeAndReturnDateIsNull(Date d);
    List<Borrowing> findBorrowingsByStatus(Status status);
    void deleteBorrowingById(int id);
}
