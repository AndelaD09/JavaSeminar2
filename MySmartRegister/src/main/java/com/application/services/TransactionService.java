package com.application.services;

import com.application.persistence.entities.Transaction;
import com.application.persistence.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addNewTransaction(Transaction transaction){ return transactionRepository.save(transaction); }

}
