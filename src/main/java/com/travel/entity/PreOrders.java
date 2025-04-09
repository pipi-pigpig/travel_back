package com.travel.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created_at;
    private String address;

}
