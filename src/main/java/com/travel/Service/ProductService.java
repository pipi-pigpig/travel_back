package com.travel.Service;

import com.travel.DTO.PostCheckOutDTO;
import com.travel.entity.Address;
import com.travel.entity.Products;

import java.util.List;

public interface ProductService {
    List<Products> find();

    List<Products> getById(Long userId);

    void addQuantity(long userId, long productId);

    void reduceQuantity(long userId, long productId);

    void deleteProduction(long userId, long productId);

    void postCheckOut(PostCheckOutDTO postCheckOutDTO);

}
