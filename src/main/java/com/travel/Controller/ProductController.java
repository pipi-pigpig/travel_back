package com.travel.Controller;


import com.travel.AtrractionsVO.OrderDetailVO;
import com.travel.DTO.PostCheckOutDTO;
import com.travel.DTO.PostDTO;
import com.travel.DTO.ProductionDTO;
import com.travel.DTO.ProductionUpdateDTO;
import com.travel.Service.ProductService;
import com.travel.entity.Address;
import com.travel.entity.PreOrders;
import com.travel.entity.Products;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
//@RequestMapping("/product")
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
            //System.out.println(postCheckOutDTO.getOrder_details());
           productService.postCheckOut(postCheckOutDTO);
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }

    }

    /*
     * 获取土特产列表
     * fetchProductions
     * 请求参数：
     * 无
     *
     * 响应参数：
     * productionList[{
     *   product_id: number,
     *   name: string,
     *   description: string,
     *   price: number,
     *   stock: number
     * },...]
     */
    @PostMapping("/fetchProductions")
    public List<Products> fetchProductions() {

        log.info("获取土特产列表");
        return productService.fetchProductions();
    }
    /*
     * 添加土特产
     * handleAddProduction
     * 请求参数：
     * {
     *   name: string,
     *   message: string,
     *   price: number,
     *   stock: number
     * }
     *
     * 响应参数：
     * {
     *   success: boolean,
     *   message: string
     * }
     */
    @PostMapping("/handleAddProduction")
    public String handleAddProduction(@RequestBody ProductionDTO productionDTO) {

        try {
            log.info("添加土特产:{}", productionDTO);
            productService.handleAddProduction(productionDTO);
            return "添加土特产成功";
        } catch (Exception e) {
            return "添加土特产失败";
        }

    }
    /*
     * 修改土特产
     * handleModifyProduction
     * 请求参数：
     * {
     *   product_id: number,
     *   name: string,
     *   message: string,
     *   price: number,
     *   stock: number
     * }
     *
     * 响应参数：
     * {
     *   success: boolean,
     *   message: string
     * }
     */
    @PostMapping("/handleModifyProduction")
    public String handleModifyProduction(@RequestBody ProductionUpdateDTO productionUpdateDTO) {


        try {
            log.info("修改土特产:{}", productionUpdateDTO);
            productService.handleModifyProduction(productionUpdateDTO);
            return "添加土特产成功";
        } catch (Exception e) {
            return "添加土特产失败";
        }

    }
    /*
     * 删除土特产(只是更新库存数量，将库存数量置为0)
     * deleteProduction
     * 请求参数：
     * {
     *   product_id: number,
     *   stock: number
     * }
     *
     * 响应参数：
     * {
     *   success: boolean,
     *   message: string
     * }
     */
    @PostMapping("/deleteProduction2")
    public String deleteProduction2(@RequestBody Map<String, Object> request) {

        try {
            long product_id = ((Number) request.get("product_id")).longValue();
            Integer stock = ((Number) request.get("stock")).intValue();
            log.info("根据id删除土特产(只是更新库存数量，将库存数量置为0):{},{}", product_id,stock);
            productService.deleteProduction2(product_id,stock);
            return "添加土特产成功";
        } catch (Exception e) {
            return "添加土特产失败";
        }

    }
    /*
     * 返回所有要审核的订单
     * fetchOrder
     * 请求参数：
     * 无
     *
     * 响应参数：
     * orders:[{
     *  order_id,
     *  status,
     *  total_price,
     *  created_at,
     *  user_id,
     *  address
     * },...]
     */
    @PostMapping("/fetchOrder")
    public List<PreOrders> fetchOrder() {

        log.info("返回所有要审核的订单");
        return productService.fetchOrder();
    }
    /*
     * 请求参数：
     * order_id:Int
     * fetchOrderDetails
     * 响应参数：
     * order_details:[{
     *  name,
     *  price,
     *  quantity
     * },...],
     */
    @PostMapping("/fetchOrderDetails")
    public  List<OrderDetailVO> fetchOrderDetails(@RequestBody Map<String, Object> request) {

            long order_id = ((Number) request.get("order_id")).longValue();
            log.info("根据id返回商品: {}", order_id);
            return  productService.fetchOrderDetails(order_id);

    }
}
