package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@SQLDelete(sql = "update product set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String name;

    @Column
    private long discountPercent;

    @Column
    private long price;

    @ManyToOne(targetEntity = Cathegory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cathegory cathegory;

    @Column
    private boolean delete = false;
}