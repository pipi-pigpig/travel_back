package com.travel.Service;

import com.travel.entity.Address;
import com.travel.entity.User;

import java.util.List;

public interface UserLoginService {
    User getUserInfo(String username, String password);

    List<Address> getById(long userId);

    void updateUser(long userId,String username);

    void deleteAddr(long addrId);
}
