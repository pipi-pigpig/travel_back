package com.travel.Service.impI;


import com.travel.Mapper.PostMapper;
import com.travel.Mapper.ProductMapper;
import com.travel.Service.ProductService;
import com.travel.entity.Products;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
