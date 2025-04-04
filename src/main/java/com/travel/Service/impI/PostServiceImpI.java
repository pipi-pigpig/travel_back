package com.travel.Service.impI;


import com.travel.DTO.PostDTO;
import com.travel.Mapper.PostMapper;
import com.travel.Service.PostService;
import com.travel.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PostServiceImpI implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> find() {
        return postMapper.finds();
    }

    @Override
    public void savePost(PostDTO postDTO) {

        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);

        post.setCreated_at(LocalDateTime.now());
        post.setUpdated_at(LocalDateTime.now());

        postMapper.insert(post);
    }

    @Override
    public Post getById(long postId) {

       Post post= postMapper.getById(postId);
        return post;
    }
}
