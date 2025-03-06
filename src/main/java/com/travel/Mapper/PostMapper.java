package com.travel.Mapper;


import com.travel.entity.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select  * from posts")
    List<Post> finds();

@Insert("insert into posts(post_id, user_id, title, message, created_at, updated_at, likes, post_partition)\n" +
        "        VALUES (#{post_id},#{user_id},#{title},#{message},#{created_at},#{updated_at},#{likes},#{post_partition})")
    void insert(Post post);




@Select("select * from posts where post_id=#{postId}")
    Post getById(long postId);
}
