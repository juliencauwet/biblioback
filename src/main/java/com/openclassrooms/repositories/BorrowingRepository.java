package com.openclassrooms.repositories;

import com.openclassrooms.entities.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing,Integer>{
}
