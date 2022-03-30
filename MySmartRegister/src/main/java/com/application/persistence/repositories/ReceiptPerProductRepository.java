package com.application.persistence.repositories;

import com.application.persistence.entities.Discount;
import com.application.persistence.entities.Product;
import com.application.persistence.entities.ReceiptPerProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ReceiptPerProductRepository extends JpaRepository<ReceiptPerProduct, Long>, PagingAndSortingRepository<ReceiptPerProduct, Long> {
    ReceiptPerProduct findByProductName(Product product);
}