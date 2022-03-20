package com.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class StockDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
