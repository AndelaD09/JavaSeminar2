package com.application.persistence.entities;

import com.application.utils.complex.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipt")
@SQLDelete(sql = "update receipt set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String storeName;

    @Column
    private Date date;

    @Column
    @Embedded
    private Address address;

    @OneToMany(targetEntity = ReceiptPerProduct.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReceiptPerProduct> productList;

    @Column
    private boolean delete = false;
}