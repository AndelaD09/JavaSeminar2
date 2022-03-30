package com.application.persistence.repositories;

import com.application.persistence.entities.Discount;
import com.application.persistence.entities.Product;
import com.application.persistence.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface StockRepository extends JpaRepository<Stock, Long>, PagingAndSortingRepository<Stock, Long> {
    Stock findByProduct(Product product);
}