package com.application.persistence.repositories;

import com.application.persistence.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}