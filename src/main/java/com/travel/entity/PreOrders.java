package com.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreOrders {

    private long order_id;
    private long user_id;
    private Integer total_price;
    private String status;
    private LocalDateTime create_at;
    private String address;

}
