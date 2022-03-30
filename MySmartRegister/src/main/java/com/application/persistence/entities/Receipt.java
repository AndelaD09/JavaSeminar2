package com.application.persistence.entities;

import com.application.utils.complex.Address;
import com.application.utils.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipt")
@SQLDelete(sql = "update receipt set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@ToString
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String storeName;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column
    private Date date;

    @Column
    @Embedded
    private Address address;

    @OneToMany(targetEntity = ReceiptPerProduct.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReceiptPerProduct> productList;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User user;

    @Column
    private double finalPrice;

    @Column
    private boolean delete = false;

    public void finalPriceCalculation(){
        this.finalPrice = productList.stream().collect(Collectors.summingDouble(product -> product.getPrice()));
    }
}