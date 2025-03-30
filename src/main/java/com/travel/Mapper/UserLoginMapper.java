package com.travel.Mapper;


import com.travel.entity.Address;
import com.travel.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserLoginMapper {

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Select("select user_addr.address,addr_id from user_addr where user_id=#{userId}")
    List<Address> getById(long userId);

    @Update("update users set username=#{username} where user_id=#{userId} ")
    void updateUser(long userId, String username);


    @Delete("delete  from user_addr where addr_id=#{addrId}")
    void deleteAddr(long addrId);

    @Update("update users set email=#{email} where user_id=#{userId} ")
    void updateEmail(long userId, String email);

    @Update("update users set phone=#{phone} where user_id=#{userId} ")
    void updatePhone(long userId, String phone);

    @Update("update users set new_address_id=#{addId} where user_id=#{userId} ")
    void updateId(long userId, long addId);

    @Update("update user_addr set address=#{address} where user_id=#{userId} and addr_id=#{addrId}")
    void updateAddress(long userId, long addId, String address);

    @Delete("delete  from user_addr where user_id=#{userId} and addr_id=#{addrId}")
    void deleteAddress(long userId, long addId);

    @Insert("insert into user_addr(user_id, address) values (#{userId},#{address})")
    void insertAddress(long userId, String address);
}
