package com.travel.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionDTO {


    private long product_id;
    private String name;
    private String message;
    private Integer price;
    private Integer stock;
}
