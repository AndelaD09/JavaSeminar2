package com.application.persistence.repositories;

import com.application.persistence.entities.CashBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CashBalanceRepository extends JpaRepository<CashBalance, Long>, PagingAndSortingRepository<CashBalance, Long> {
}