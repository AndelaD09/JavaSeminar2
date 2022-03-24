package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class ReceiptPerProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @OneToOne
    private Product productName;

    @Column
    private int quantity;

    @Column
    private long totalPrice;

    @Column
    private boolean delete = false;
}
