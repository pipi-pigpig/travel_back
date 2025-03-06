package com.travel.Controller;


import com.travel.DTO.PostDTO;
import com.travel.Service.PostService;
import com.travel.entity.Post;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/getPosts")
    public List<Post> getUser(){

        return postService.find();
    }

    @GetMapping("/{post_id}")
    public Result<Post> getUsers(@PathVariable long post_id){

        Post post= postService.getById(post_id);
        return Result.success(post);
    }


    @PostMapping("/createPost")
    public Result savePost(@RequestBody PostDTO postDTO){

        log.info("新增帖子:{}", postDTO);
        postService.savePost(postDTO);
        return Result.success();
    }
}
