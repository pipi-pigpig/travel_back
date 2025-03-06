package com.travel.Controller;


import com.travel.Service.ProductService;
import com.travel.entity.Products;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
    获得产品
     */
    @PostMapping("/getProducts")
    public List<Products> GetProducts() {

        return productService.find();
    }
}
