package com.projetouninove.saldosmart.business;

import com.projetouninove.saldosmart.infrastructure.entity.Transaction;
import com.projetouninove.saldosmart.infrastructure.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Page<Transaction> getTransactions(Specification<Transaction> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
        // var probe = Transaction.builder()
        //     .description(filters.description())
        //     .date(filters.date())
        //     .build();

        // var matcher = ExampleMatcher.matchingAll()
        //     .withIgnoreNullValues()
        //     .withIgnoreCase()
        //     .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        // var example = Example.of(probe, matcher);
    }
}
