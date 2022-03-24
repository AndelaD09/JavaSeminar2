package com.application.persistence.entities;

import com.application.utils.complex.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Table(name = "store")
@SQLDelete(sql = "update store set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String storeName;

    @Embedded
    @Column
    private Address address;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
    private List<Product> products;

    @Column
    private boolean delete = false;
}