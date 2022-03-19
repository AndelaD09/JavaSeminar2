package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "transaction")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private long total;

    @Column
    private String description;

    @ManyToOne(targetEntity = CashDevice.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private long CashDeviceID;
}