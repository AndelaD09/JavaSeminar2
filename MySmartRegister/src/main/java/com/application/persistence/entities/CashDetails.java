package com.application.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashDetails {
    private int deposit;
    private long total;
}
