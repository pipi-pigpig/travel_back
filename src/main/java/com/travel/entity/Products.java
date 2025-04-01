package com.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    private long product_id;
    private String name;
    private String message;
    private Integer price;
    private String image;
    private Integer stock;
    private Integer quantity;
    private LocalDateTime created_at ;     // created_at
    private LocalDateTime updated_at ;
    private String keyword;
}
