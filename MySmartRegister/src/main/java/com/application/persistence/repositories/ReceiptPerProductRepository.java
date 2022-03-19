package com.application.persistence.repositories;

import com.application.persistence.entities.ReceiptPerProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptPerProductRepository extends JpaRepository<ReceiptPerProduct, Long> {
}