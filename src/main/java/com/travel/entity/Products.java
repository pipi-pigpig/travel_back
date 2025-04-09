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
    private Integer quantity;
    private Integer stock;
    private LocalDateTime created_at ;
    private LocalDateTime updated_at ;

}
