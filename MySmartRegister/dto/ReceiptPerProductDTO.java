package com.application.dto;

import lombok.Data;

@Data
public class ReceiptPerProductDTO {
    private Long id;
    private ProductDTO productName;
    private Integer quantity;
    private Long totalPrice;
}
