package com.application.services;

import com.application.exception_wrappers.NotFoundException;
import com.application.persistence.entities.Receipt;
import com.application.persistence.entities.ReceiptPerProduct;
import com.application.persistence.repositories.ReceiptPerProductRepository;
import com.application.persistence.repositories.ReceiptRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptPerProductRepository receiptPerProductRepository;

    public void setReceiptPerProduct(ReceiptPerProduct receipt){ receiptPerProductRepository.save(receipt);}

    public void saveReceipt(Receipt receipt){
        receiptRepository.save(receipt);
    }

    public List<ReceiptPerProduct> setProductToReceipt(ReceiptPerProduct receiptPerProduct, Date date){
        var receipt = receiptRepository.findReceiptByDate(date);
        if (receipt.equals(null)){
            receipt.setDate(date);
            receiptRepository.save(receipt);
            return setProductToReceipt(receiptPerProduct, date);
        }
        receipt.getProductList().add(receiptPerProduct);
        receiptRepository.save(receipt);
        return receipt.getProductList();
    }

    public List<Receipt> getHistory(List<Receipt> receipts){ return receiptRepository.findAll();}

    public void deleteAllReceipts(){ receiptRepository.deleteAll();}

    public void cancelReceipt(long id){
        var receipt = receiptRepository.findById(id).orElseThrow(() -> new NotFoundException("Unable to find"));

        receipt.setDelete(true);
        receiptRepository.save(receipt);
    }

    public void deleteByID(long id){ receiptRepository.deleteById(id);}
}
