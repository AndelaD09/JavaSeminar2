package com.application.services;

import com.application.exception_wrappers.NotFoundException;
import com.application.persistence.entities.CashBalance;
import com.application.persistence.entities.Cathegory;
import com.application.persistence.entities.Product;
import com.application.persistence.entities.Transaction;
import com.application.persistence.repositories.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class SoftDeletingService {
    @Autowired
    private CashBalanceRepository cashBalanceRepository;
    @Autowired
    private CathegoryRepository cathegoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    private List<Transaction> readBalance(long id){
        var cash = cashBalanceRepository.findById(id).orElseThrow(() -> new NotFoundException("balance closed"));
        var listTransactions = new ArrayList<Transaction>();

        cash.getPayementHistory().stream()
                                 .filter(c -> c.isDelete() == false)
                                 .collect(Collectors.toList());

        return listTransactions;
    }

    private List<Cathegory> readCathegories(){
        var cathegories = cathegoryRepository.findAll();
        var catList = new ArrayList<Cathegory>();

        cathegories.stream()
                   .filter(c -> c.isDelete() == false)
                   .collect(Collectors.toList());

        return catList;
    }

    private List<Product> readProducts(){
        var products = productRepository.findAll();
        var prodList = new ArrayList<Product>();

        products.stream()
                .filter(c -> c.isDelete() == false)
                .collect(Collectors.toList());

        return prodList;
    }
}
