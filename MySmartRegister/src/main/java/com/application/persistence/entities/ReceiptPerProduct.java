package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "invoice_per_product")
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
}
