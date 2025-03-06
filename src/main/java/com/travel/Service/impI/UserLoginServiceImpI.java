package com.travel.Service.impI;


import com.travel.Mapper.UserLoginMapper;
import com.travel.Service.UserLoginService;
import com.travel.entity.Address;
import com.travel.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserLoginServiceImpI implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public User getUserInfo(String username, String password) {
        User user = userLoginMapper.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) { // 这里可以放入加密校验逻辑
            return user;
        }
        return null; // 用户不存在或密码错误
    }

    @Override
    public List<Address> getById(long userId) {

        List<Address> addresses=userLoginMapper.getById(userId);
        return addresses;
    }

    @Override
    public void updateUser(long userId, String username) {
        userLoginMapper.updateUser(userId,username);

    }

    @Override
    public void deleteAddr(long addrId) {

        userLoginMapper.deleteAddr(addrId);
    }
}

