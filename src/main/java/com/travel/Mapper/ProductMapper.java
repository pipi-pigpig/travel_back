package com.travel.Mapper;


import com.travel.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from local_products limit  12")
    List<Products> finds();

}
