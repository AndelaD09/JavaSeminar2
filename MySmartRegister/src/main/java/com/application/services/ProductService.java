package com.application.services;

import com.application.persistence.entities.Product;
import com.application.persistence.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    private Product findProductByName(String name){
        return productRepository.findProductByName(name);
    }


}
