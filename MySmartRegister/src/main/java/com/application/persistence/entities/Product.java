package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "product")
@SQLDelete(sql = "update product set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Discount discount;

    @Column
    private double price;

    @ManyToOne(targetEntity = Cathegory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cathegory cathegory;

    @Column
    private boolean delete = false;

    public Product(long ID, String name, double price, boolean delete) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.delete = delete;
    }
}