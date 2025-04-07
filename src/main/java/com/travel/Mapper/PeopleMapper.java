package com.travel.Mapper;


import com.travel.entity.FamousPeople;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PeopleMapper {


    @Select("select  * from famous_people")
    List<FamousPeople> finds();



    @Select("select famous_people.person_id,name,message,image,created_at,updated_at from  famous_people, attraction_famous_people where attraction_id=#{attractionId} and famous_people.person_id=attraction_famous_people.person_id")
    List<FamousPeople> getById(Integer attractionId);


    @Select("select * from famous_people")
    List<FamousPeople> getPeoples();
}
