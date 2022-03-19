package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
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
}