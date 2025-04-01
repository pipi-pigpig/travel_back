package com.travel.Mapper;


import com.travel.entity.Address;
import com.travel.entity.Products;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from local_products limit  12")
    List<Products> finds();

    @Select("select shopping_cart.product_id,shopping_cart.quantity,local_products.name,local_products.image,local_products.price from local_products,shopping_cart\n" +
            "where user_id=#{userId} and local_products.product_id=shopping_cart.product_id;")
    List<Products> getById(Long userId);

    @Update("update shopping_cart set quantity=quantity+1 where user_id=#{userId} and product_id=#{productId}")
    void addQuantity(long userId, long productId);

    @Update("update shopping_cart set quantity=quantity-1 where user_id=#{userId} and product_id=#{productId}")
    void reduceQuantity(long userId, long productId);

    @Delete("delete  from shopping_cart where user_id=#{userId} and product_id=#{productId}")
    void deleteProduction(long userId, long productId);

}
