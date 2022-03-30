package com.application.persistence.repositories;

import com.application.persistence.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long>, PagingAndSortingRepository<Discount, Long> {
    Discount findByPercent(long percent);
}