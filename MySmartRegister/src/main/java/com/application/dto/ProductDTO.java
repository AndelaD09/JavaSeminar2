package com.application.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Long discountPercent;
    private CathegoryDTO cathegory;
}
