package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "receipt_per_product")
@SQLDelete(sql = "update receipt_per_product set delete = true where ID=?")
@Where(clause = "delete = false")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReceiptPerProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @OneToOne
    private Product productName;

    @Column
    private double price = productName.getPrice();

    @Column
    private int quantity;

    @Column
    private double totalPrice = quantity*productName.getPrice();

    @Column
    private boolean delete = false;

    public ReceiptPerProduct(long ID, Product productName, double price, int quantity, boolean delete) {
        this.ID = ID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.delete = delete;
    }
}
