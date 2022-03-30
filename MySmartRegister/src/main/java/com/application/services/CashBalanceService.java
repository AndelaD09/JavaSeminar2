package com.application.services;

import com.application.persistence.entities.CashBalance;
import com.application.persistence.entities.Transaction;
import com.application.persistence.repositories.CashBalanceRepository;
import com.application.persistence.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashBalanceService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CashBalanceRepository cashBalanceRepository;

    public CashBalance addDeposit(){
        var cash = new CashBalance();
        cash.setDeposit(100);
        return cash;
    }

    public CashBalance addTransaction(long id, Transaction transaction){
        var cash = cashBalanceRepository.findById(id).orElse(addDeposit());

        transaction.totalCalculation();
        cash.getPayementHistory().add(transaction);
        return cash;
    }

    public CashBalance updateBalance(long id, Transaction transaction){
        var cash = cashBalanceRepository.findById(id).orElse(addDeposit());

        transaction.totalCalculation();
        cash.getPayementHistory().add(transaction);
        return cash;
    }

    public void deleteTransaction(long idB, long idT){
        var cash = cashBalanceRepository.findById(idB).orElse(addDeposit());

        cash.getPayementHistory().stream()
                                 .forEach(trans -> {if (trans.getID() == idT); cash.getPayementHistory().remove(trans);});
    }

    public void softDeleteTransaction(long idB, long idT){
        var cash = cashBalanceRepository.findById(idB).orElse(addDeposit());

        cash.getPayementHistory().stream()
                                 .forEach(trans -> {if (trans.getID() == idT); trans.setDelete(true);});
    }
}
