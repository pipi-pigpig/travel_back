package com.travel.Service;

import com.travel.DTO.PostDTO;
import com.travel.DTO.UpdatePostDTO;
import com.travel.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> find();

    void savePost(PostDTO postDTO);

    Post getById(long postId);

    void deletePost(long postId);

    Post fetchPostsDetails(long postId);

    int handleLikes1(long postId);

    int likeComment(long postCommentId);

    void deleteComment(long postCommentId);

    void updatePost(UpdatePostDTO updatePostDTO);

    int likeComment4(long postId);
}
