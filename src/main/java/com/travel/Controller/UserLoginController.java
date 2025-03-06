package com.travel.Controller;


import com.travel.Service.UserLoginService;
import com.travel.entity.Address;
import com.travel.entity.User;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping
    public Result<User> login(@RequestParam String username,@RequestParam String password) {
        User user = userLoginService.getUserInfo(username, password);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("用户不存在或密码错误");
        }

    }

    @GetMapping("/{user_id}")
    public List<Address> getAddress(@PathVariable long user_id) {

        List<Address> addresses=userLoginService.getById(user_id);
        return addresses;
    }

    @PostMapping
    public  Result updateUser(@RequestParam long user_id,@RequestParam String username) {


        userLoginService.updateUser(user_id,username);
        return Result.success();
    }

    @DeleteMapping("/{addr_id}")
    public Result deleteAttraction(@PathVariable long addr_id) {

        userLoginService.deleteAddr(addr_id);
        return Result.success();
    }

}
