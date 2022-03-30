package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Table(name = "transaction")
@SQLDelete(sql = "update transaction set delete = true where ID=?")
@Where(clause = "delete = false")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long ID;

    @OneToMany(targetEntity = Receipt.class)
    private Set<Receipt> history;

    @Column
    private double total;

    @Column
    private String description;

    @Column
    private boolean delete = false;

    public Transaction(long ID, double total, String description, boolean delete) {
        this.ID = ID;
        this.total = total;
        this.description = description;
        this.delete = delete;
    }
    public void totalCalculation(){
        this.total = history.stream().collect(Collectors.summingDouble(h -> h.getFinalPrice()));
    }
}