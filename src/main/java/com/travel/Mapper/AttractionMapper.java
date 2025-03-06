package com.travel.Mapper;


import com.travel.entity.Attractions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttractionMapper {

    @Select("select  * from attractions")
    List<Attractions> finds();


    @Select("select  * from attractions where attraction_id=#{attractionId}")
    Attractions getById(Integer attractionId);
}
