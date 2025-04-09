package com.travel.Service.impI;


import com.travel.VO.OrderDetailVO;
import com.travel.DTO.PostCheckOutDTO;
import com.travel.DTO.ProductionDTO;
import com.travel.DTO.ProductionUpdateDTO;
import com.travel.Mapper.ProductMapper;
import com.travel.Service.ProductService;
import com.travel.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpI implements ProductService {

@Autowired
private ProductMapper productMapper;


    @Override
    public List<Products> find() {
        return productMapper.finds();
    }

    @Override
    public List<Products> getById(Long userId) {

        return productMapper.getById(userId);
    }

    @Override
    public void addQuantity(long userId, long productId) {

        productMapper.addQuantity(userId,productId);
    }

    @Override
    public void reduceQuantity(long userId, long productId) {
        productMapper.reduceQuantity(userId,productId);
    }

    @Override
    public void deleteProduction(long userId, long productId) {
        productMapper.deleteProduction(userId,productId);
    }

    @Override
    @Transactional
    public void postCheckOut(PostCheckOutDTO postCheckOutDTO) {

        PreOrders preOrders = new PreOrders();
        BeanUtils.copyProperties(postCheckOutDTO,preOrders);
        preOrders.setCreated_at(LocalDateTime.now());
        preOrders.setStatus("pending");
        //preOrders.setOrder_id(1);
        productMapper.insert(preOrders);

        long orderId= preOrders.getOrder_id();


        List<OrderDetail> orderDetail=postCheckOutDTO.getOrder_details();
        System.out.println("666:"+orderDetail);
        if (orderDetail!=null&&orderDetail.size()>0){
            for (OrderDetail orderDetail1 : orderDetail) {

                orderDetail1.setOrder_id(orderId);

                productMapper.insertOrderDetail(orderDetail1);
            }
            //productMapper.insertBatch(orderDetail);
        }

    }

    @Override
    public List<Products> fetchProductions() {
        return productMapper.getProductions();
    }

    @Override
    public void handleAddProduction(ProductionDTO productionDTO) {
        Products product=new Products();
        BeanUtils.copyProperties(productionDTO,product);
        product.setCreated_at(LocalDateTime.now());
        product.setUpdated_at(LocalDateTime.now());
        product.setImage("null");
        productMapper.insertProduction(product);
    }

    @Override
    public void handleModifyProduction(ProductionUpdateDTO productionUpdateDTO) {

       long product_id= productionUpdateDTO.getProduction_id();
       String name = productionUpdateDTO.getName();
       String message = productionUpdateDTO.getMessage();
       Integer price = productionUpdateDTO.getPrice();
       Integer stock = productionUpdateDTO.getStock();
       productMapper.updateProduction(product_id,name,message,price,stock);
    }

    @Override
    public void deleteProduction2(long productId, Integer stock) {
        productMapper.updateStock(productId,stock);
    }

    @Override
    public List<PreOrders> fetchOrder() {
        return productMapper.getOrders();
    }

    @Override
    public List<OrderDetailVO> fetchOrderDetails(long orderId) {
        return productMapper.getOrderDetails(orderId);
    }

    @Override
    public List<PreOrders> fetchUserOrder(long userId) {
        return productMapper.getAllOrders(userId);
    }

    @Override
    public void postAddShopCart(long userId, long productId, long quantity) {
        productMapper.insertShopCart(userId,productId,quantity);
    }
}
