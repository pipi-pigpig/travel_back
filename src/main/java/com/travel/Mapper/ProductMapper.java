package com.travel.Mapper;


import com.travel.entity.Address;
import com.travel.entity.OrderDetail;
import com.travel.entity.PreOrders;
import com.travel.entity.Products;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into pre_orders( user_id, total_price, status, created_at, address)" +
            "values (#{user_id},#{total_price},#{status},#{created_at},#{address})")
    void insert(PreOrders preOrders);

    void insertBatch(List<OrderDetail> orderDetail);

    @Select("select * from local_products")
    List<Products> getProductions();

    @Insert("insert into local_products(name, messsage, price, image, stock, created_at, updated_at)" +
            "values (#{name},#{messsage},#{price},#{image},#{stock},#{created_at},#{updated_at})")
    void insertProduction(Products product);
}
