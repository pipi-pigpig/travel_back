package com.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    private  long order_detail_id;
    private long order_id;
    private long product_id;
    private Integer quantity;
    private Integer price;

}
