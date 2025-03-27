package com.travel.Controller;


import com.travel.Service.UserLoginService;
import com.travel.entity.Address;
import com.travel.entity.LoginRequest;
import com.travel.entity.User;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
//@RequestMapping("/userInfo")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/userInfo")
    public Result<User> login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        System.out.println(username+":"+password);
        User user = userLoginService.getUserInfo(username, password);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("用户不存在或密码错误");
        }

    }
/*
获得地址
 */
    @PostMapping("/user_id")
    public List<Address> getAddress(@RequestBody Map<String, Long> request) {

        Long user_id= request.get("user_id");
        log.info("根据id查地址: {}", user_id);
        return userLoginService.getById(user_id);
    }


/*
修改用户名
 */
    @PostMapping("/updateUsername")
    public  int updateUser(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            String username = (String) request.get("username");
            log.info("根据id修改username: {},{}", user_id,username);
            userLoginService.updateUser(user_id,username);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /*
    修改邮箱updateEmail
     */

    @PostMapping("/updateEmail")
    public  int updateEmail(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            String email = (String) request.get("email");
            log.info("根据id修改email: {},{}", user_id,email);
            userLoginService.updateEmail(user_id,email);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /*
    更新电话updatePhone
     */
    @PostMapping("/updatePhone")
    public  int updatePhone(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            String phone = (String) request.get("phone");
            log.info("根据id修改phone: {},{}", user_id,phone);
            userLoginService.updatePhone(user_id,phone);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    @DeleteMapping("/{addr_id}")
    public Result deleteAttraction(@PathVariable long addr_id) {

        userLoginService.deleteAddr(addr_id);
        return Result.success();
    }

    /*
     * 更新当前使用的地址
     *
     * 请求参数：
     * user_id:String,
     * add_id:String
     *
     * 响应参数：
     * 是否更新成功
     */
    @PostMapping("/updateNowAddress")
    public  int updateNowAddress(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            long add_id = ((Number) request.get("add_id")).longValue();
            log.info("根据id修改更新当前使用的地址: {},{}", user_id,add_id);
            userLoginService.updateNowAddress(user_id,add_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 更新地址内容
     *
     * 请求参数：
     * user_id:String,
     * addr_id:String,
     * address:String
     *
     * 响应参数：
     * 是否更新成功
     */
    @PostMapping("/updateAddress")
    public  int updateAddress(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            long add_id = ((Number) request.get("add_id")).longValue();
            String address = (String) request.get("address");

            log.info("根据id修改更新地址内容: {},{},{}", user_id,add_id,address);
            userLoginService.updateAddress(user_id,add_id,address);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /*
     * 删除地址
     *
     * 请求参数：
     * user_id:String,
     * addr_id:String
     *
     * 响应参数：
     * 是否删除成功
     * deleteAddress
     */


    @PostMapping("/deleteAddress")
    public  int deleteAddress(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            long add_id = ((Number) request.get("add_id")).longValue();


            log.info("根据id修改删除地址: {},{}", user_id,add_id);
            userLoginService.deleteAddress(user_id,add_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 增加地址
     *
     * 请求参数：
     * user_id:String,
     * address:String
     *
     * 响应参数：
     * addr_id  (后端分配好addr_id后，将addr_id返回)
     */
    @PostMapping("/addAddress")
    public  int addAddress(@RequestBody Map<String, Object> request) {


        try {
            long user_id = ((Number) request.get("user_id")).longValue();
            String address = (String) request.get("address");


            log.info("根据id增加地址: {},{}", user_id,address);
            userLoginService.addAddress(user_id,address);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
}
