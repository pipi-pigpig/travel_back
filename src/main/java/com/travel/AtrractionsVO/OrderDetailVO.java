package com.travel.AtrractionsVO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailVO {


    private String name;
    private Integer quantity;
    private Integer price;
}
