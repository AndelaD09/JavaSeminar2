package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String name;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;
}