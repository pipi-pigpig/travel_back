package com.travel.Mapper;


import com.travel.entity.Post;
import org.apache.ibatis.annotations.*;

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


@Delete("delete  from posts where post_id=#{postId}")
    void deletePostById(long postId);

@Select("select posts.likes from posts where post_id=#{postId}")
    int getLikesById(long postId);

    @Select("select likes from post_comments where post_comment_id=#{postCommentId}")
    int getCommentLikesById(long postCommentId);

    @Update("update post_comments set likes=likes+1 where post_comment_id=#{postCommentId}")
    void updateLikes(long postCommentId);

    @Delete("delete  from post_comments where post_comment_id=#{postCommentId}")
    void deleteById(long postCommentId);
}
