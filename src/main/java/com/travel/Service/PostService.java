package com.travel.Service;

import com.travel.DTO.PostDTO;
import com.travel.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> find();

    void savePost(PostDTO postDTO);

    Post getById(long postId);

    void deletePost(long postId);

    Post fetchPostsDetails(long postId);

    int handleLikes1(long postId);
}
