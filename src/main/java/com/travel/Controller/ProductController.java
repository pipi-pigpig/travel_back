package com.travel.Controller;


import com.travel.DTO.PostCheckOutDTO;
import com.travel.Service.ProductService;
import com.travel.entity.Address;
import com.travel.entity.Products;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    /*
     * 获取用户购物车的所有商品
     *fetchShopCart
     * 请求参数：
     * user_id:String，
     *
     * 响应参数：
     * product_id，
     * quantity，
     * name，
     * image
     */
    @PostMapping("/fetchShopCart")
    public List<Products> fetchShopCart(@RequestBody Map<String, Long> request) {

        Long user_id= request.get("user_id");
        log.info("根据id获取用户购物车的所有商品: {}", user_id);
        return productService.getById(user_id);
    }
    /*
     * 购物车某商品的数量加1
     *addQuantity
     * 请求参数：
     * user_id:String，
     * product_id:String
     *
     * 响应参数：
     * 是否添加成功
     */
    @PostMapping("/addQuantity")
    public  int addQuantity(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            long product_id = ((Number) request.get("product_id")).longValue();

            log.info("根据id修改购物车某商品的数量加1: {},{}", user_id,product_id);
            productService.addQuantity(user_id,product_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 购物车某商品的数量减1
     * reduceQuantity
     * 请求参数：
     * user_id:String，
     * product_id:String
     *
     * 响应参数：
     * 是否减少成功
     */
    @PostMapping("/reduceQuantity")
    public  int reduceQuantity(@RequestBody Map<String, Object> request) {

        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            long product_id = ((Number) request.get("product_id")).longValue();

            log.info("根据id修改购物车某商品的数量减1: {},{}", user_id,product_id);
            productService.reduceQuantity(user_id,product_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /*
     * 删除购物车某商品
     * deleteProduction
     * 响应参数：
     * user_id:String，
     * product_id:String
     *
     * 响应参数：
     * 是否删除成功
     */

    @PostMapping("/deleteProduction")
    public  int deleteProduction(@RequestBody Map<String, Object> request) {

        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            long product_id = ((Number) request.get("product_id")).longValue();


            log.info("根据id删除购物车某商品: {},{}", user_id,product_id);
            productService.deleteProduction(user_id,product_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 用户结算账单
     *postCheckOut
     * 请求参数：
     * user_id:String,
     * total_price:Number,
     * address:String,
     * order_details:[{
     *  product_id:String,
     *  quantity:Number,
     *  price:Number
     * },...]
     *
     * 响应参数：
     * 是否提交结算成功
     */

    @PostMapping("/postCheckOut")
    public  int postCheckOut(@RequestBody PostCheckOutDTO postCheckOutDTO) {
        try {
            log.info("根据id修改用户结算账单");
            productService.postCheckOut(postCheckOutDTO);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

}
