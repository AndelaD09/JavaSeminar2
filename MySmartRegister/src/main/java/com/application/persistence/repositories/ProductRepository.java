package com.application.persistence.repositories;

import com.application.persistence.entities.Cathegory;
import com.application.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findProductByCathegory(Cathegory cathegory);

    public Product findProductByDiscountPercent(float discount);

    public Product findProductByName(String name);
}