package com.travel.Mapper;


import com.travel.entity.Attractions;
import com.travel.entity.FamousPeople;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AttractionMapper {

    @Select("select  * from attractions")
    List<Attractions> finds();


    @Select("select  * from attractions where attraction_id=#{attractionId}")
    Attractions getById(long attractionId);


    @Select("select * from famous_people where person_id in (select person_id from attraction_famous_people where attraction_id=#{attractionId})")
    List<FamousPeople> getFamousPeopleById(long attractionId);

    @Select("select * from attractions where attraction_id=#{attractionId}")
    int getLikes(long attractionId);

    @Delete("delete from attractions where attraction_id=#{attractionId} ")
    void deleteById(long attractionId);

    @Update("update attractions set likes=likes+1 where attraction_id=#{attractionId}")
    void updateLikes(long attractionId);
}
