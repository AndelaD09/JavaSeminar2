package com.application.dto;

import com.application.persistence.entities.Address;
import lombok.Data;

import java.util.List;

@Data
public class StoreDTO {
    private Long ID;
    private String storeName;
    private Address address;
    private List<ProductDTO> products;

}
