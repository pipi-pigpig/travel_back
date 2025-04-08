package com.travel.Service;

import com.travel.AtrractionsVO.OrderDetailVO;
import com.travel.DTO.PostCheckOutDTO;
import com.travel.DTO.ProductionDTO;
import com.travel.DTO.ProductionUpdateDTO;
import com.travel.entity.Address;
import com.travel.entity.PreOrders;
import com.travel.entity.Products;

import java.util.List;

public interface ProductService {
    List<Products> find();

    List<Products> getById(Long userId);

    void addQuantity(long userId, long productId);

    void reduceQuantity(long userId, long productId);

    void deleteProduction(long userId, long productId);

    void postCheckOut(PostCheckOutDTO postCheckOutDTO);

    List<Products> fetchProductions();

    void handleAddProduction(ProductionDTO productionDTO);

    void handleModifyProduction(ProductionUpdateDTO productionUpdateDTO);

    void deleteProduction2(long productId, Integer stock);

    List<PreOrders> fetchOrder();

    List<OrderDetailVO> fetchOrderDetails(long orderId);
}
