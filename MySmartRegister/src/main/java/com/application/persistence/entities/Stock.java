package com.application.persistence.entities;

import com.application.utils.complex.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
@SQLDelete(sql = "update stock set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Embedded
    private Address address;

    @OneToOne(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

    @Column
    private int quantityPerProduct;

    @Column
    private boolean delete = false;
}