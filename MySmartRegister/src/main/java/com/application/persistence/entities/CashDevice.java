package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "cash_device")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @Column
    private String DeviceName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = User.class)
    private List<UserType> userType;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Store.class)
    private Store store;

    @Column
    private Date openingDate;

    @Column
    private Date closingDate;

    @ManyToOne(targetEntity = Store.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Store storeInformation;

    @Embedded
    @Column
    private CashDetails cashDetails;
}