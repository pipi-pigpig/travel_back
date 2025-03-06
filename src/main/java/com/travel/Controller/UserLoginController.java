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
import java.util.Objects;

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
    @PostMapping("/username")
    public  Result updateUser(@RequestBody Map<String, Object> request) {

      long user_id = ((Number) request.get("user_id")).longValue();
       String username = (String) request.get("username");
        log.info("根据username查睡眠: {},{}", user_id,username);
        userLoginService.updateUser(user_id,username);
        return Result.success();
    }

    @DeleteMapping("/{addr_id}")
    public Result deleteAttraction(@PathVariable long addr_id) {

        userLoginService.deleteAddr(addr_id);
        return Result.success();
    }

}
