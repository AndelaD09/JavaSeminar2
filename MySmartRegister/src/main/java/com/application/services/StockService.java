package com.application.services;

import com.application.persistence.entities.Product;
import com.application.persistence.entities.Stock;
import com.application.persistence.repositories.StockRepository;
import com.application.utils.complex.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public void addNewStock(Address address){
        var stock = new Stock();
        stock.setAddress(address);
        stock.setDelete(false);
        stockRepository.save(stock);
    }

    public List<Stock> listStocks(){
        return stockRepository.findAll();
    }

    public Stock addProductToStock(long id, Product product, int quantity){
        var stock = stockRepository.findById(id).orElse(null);
        if (!stock.getProduct().equals(null))
            return updateProductOfStock(product, quantity);

        stock.setProduct(product);
        stock.setQuantityPerProduct(quantity);
        stockRepository.save(stock);
        return stock;
    }

    public Stock updateProductOfStock(Product product, int quantity){
        var stock = stockRepository.findByProduct(product);

        stock.setQuantityPerProduct(stock.getQuantityPerProduct() + quantity);
        stockRepository.save(stock);
        return stock;
    }

    public void updateSoldProduct(Product product, int sold){
        var stock = stockRepository.findByProduct(product);

        stock.setQuantityPerProduct(stock.getQuantityPerProduct() - sold);
        stockRepository.save(stock);
    }

    public void removeProduct(Product product){
        var stock = stockRepository.findByProduct(product);

        stock.getProduct().setDelete(true);
        stock.setQuantityPerProduct(0);
        stockRepository.save(stock);
    }
}
