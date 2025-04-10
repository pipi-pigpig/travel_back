package com.travel.Mapper;


import com.travel.VO.OrderDetailVO;
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
    @Options(useGeneratedKeys = true, keyProperty = "order_id", keyColumn = "order_id")
    void insert(PreOrders preOrders);

    //void insertBatch(List<OrderDetail> orderDetail);
    void insertBatch(@Param("list") List<OrderDetail> orderDetail);

    @Select("select * from local_products")
    List<Products> getProductions();

    @Insert("insert into local_products(name, message, price, image, stock, created_at, updated_at)" +
            "values (#{name},#{message},#{price},#{image},#{stock},#{created_at},#{updated_at})")
    @Options(useGeneratedKeys = true, keyProperty = "product_id", keyColumn = "product_id")
    void insertProduction(Products product);

    @Update("update local_products set name=#{name},message=#{message},price=#{price},stock=#{stock} where product_id=#{productId}")
    void updateProduction(long productId, String name, String message, Integer price, Integer stock);

    @Update("update local_products set stock=0 where product_id=#{productId}")
    void updateStock(long productId, Integer stock);

    @Select("select * from pre_orders where status='pending'")
    List<PreOrders> getOrders();

    @Select("select local_products.name,order_details.quantity,local_products.price*order_details.quantity as price from local_products,pre_orders,order_details\n" +
            "where pre_orders.order_id=#{orderId}\n" +
            "and  order_details.order_id=pre_orders.order_id\n" +
            "and order_details.product_id=local_products.product_id;")
    List<OrderDetailVO> getOrderDetails(long orderId);

    @Insert("insert into  order_details(order_id, product_id, quantity, price) VALUES " +
            "(#{order_id},#{product_id},#{quantity},#{price})")
    @Options(useGeneratedKeys = true, keyProperty = "order_detail_id", keyColumn = "order_detail_id")
    void insertOrderDetail(OrderDetail orderDetail1);

    @Select("select  * from pre_orders where user_id=#{userId}")
    List<PreOrders> getAllOrders(long userId);

    @Insert("insert into shopping_cart(user_id, product_id, quantity) VALUES " +
            "(#{userId},#{productId},#{quantity})")
    void insertShopCart(long userId, long productId, long quantity);
}
