package com.projetouninove.saldosmart.controller;

import com.projetouninove.saldosmart.infrastructure.entity.Transaction;
import com.projetouninove.saldosmart.infrastructure.entity.TransactionFilters;
import com.projetouninove.saldosmart.infrastructure.repository.TransactionRepository;
import com.projetouninove.saldosmart.business.TransactionService;
import com.projetouninove.saldosmart.infrastructure.config.TransactionSpecification;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public Page<Transaction> index(TransactionFilters filters, @PageableDefault(size = 10, sort = "date", direction = Direction.DESC) Pageable pageable){
        var specification = TransactionSpecification.build(filters);
        return transactionService.getTransactions(specification, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(@RequestBody @Valid Transaction transaction) {
        log.info("cadastrando transação" + transaction);
        return repository.save(transaction);
    }
}
