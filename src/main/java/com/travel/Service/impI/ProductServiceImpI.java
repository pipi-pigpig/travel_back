package com.travel.Service.impI;


import com.travel.DTO.PostCheckOutDTO;
import com.travel.DTO.ProductionDTO;
import com.travel.Mapper.PostMapper;
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
        preOrders.setCreate_at(LocalDateTime.now());
        preOrders.setStatus("pending");
        //preOrders.setOrder_id(1);
        productMapper.insert(preOrders);

        long orderId= preOrders.getOrder_id();


        List<OrderDetail> orderDetail=postCheckOutDTO.getOrder_details();
        System.out.println("666:"+orderDetail);
        if (orderDetail!=null&&orderDetail.size()>0){
            for (OrderDetail orderDetail1 : orderDetail) {

                orderDetail1.setOrder_id(orderId);
            }
            productMapper.insertBatch(orderDetail);
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
}
