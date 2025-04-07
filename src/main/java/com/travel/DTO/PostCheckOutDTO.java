package com.travel.DTO;

import com.travel.entity.OrderDetail;
import com.travel.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCheckOutDTO {

    private long user_id;
    private Integer total_price;
    private String address;

    private List<OrderDetail> order_details=new ArrayList<>();
}
