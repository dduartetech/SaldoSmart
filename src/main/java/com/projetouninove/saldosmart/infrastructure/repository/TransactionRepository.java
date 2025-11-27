package com.projetouninove.saldosmart.infrastructure.repository;

import com.projetouninove.saldosmart.infrastructure.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

    // SELECT * Transaction WHERE UPPER(description) like UPPER(%Java%)
    List<Transaction> findByDescriptionContainingIgnoreCase(String description);

    List<Transaction> findByDescriptionContainingIgnoreCaseAndDate(String description, LocalDate date);

    List<Transaction> findByDate(LocalDate date);

    // @Query("SELECT t FROM Transaction t ORDER BY t.date LIMIT ?1 OFFSET ?2 " ) //JPQL
    // List<Transaction> findAll(int size, int offset);

    //Java Persistence Query Language
    //@Query("SELECT t FROM Transaction WHERE date < now()")
    //List<Transaction> buscaPersonalizada(String criterio);    
}
