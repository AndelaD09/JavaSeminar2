package com.application.dto;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long ID;
    private Integer total;
    private String description;
    private Long CashDeviceID;
}
