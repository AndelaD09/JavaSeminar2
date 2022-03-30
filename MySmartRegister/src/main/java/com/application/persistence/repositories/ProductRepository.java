package com.application.persistence.repositories;

import com.application.persistence.entities.Cathegory;
import com.application.persistence.entities.Discount;
import com.application.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.ArrayList;

@Component
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
    public Product findProductByCathegory(Cathegory cathegory);

    public Product findProductByDiscountPercent(Discount discount);

    public Product findProductByName(String name);

    ArrayList<Product> findProductByPrice(long price, Pageable pageable);
}