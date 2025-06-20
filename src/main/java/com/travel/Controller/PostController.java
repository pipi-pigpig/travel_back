package com.travel.Controller;


import com.travel.DTO.PostDTO;
import com.travel.DTO.ProductionUpdateDTO;
import com.travel.DTO.UpdatePostDTO;
import com.travel.Service.PostService;
import com.travel.VO.AttractionsVO;
import com.travel.VO.CommentsVO;
import com.travel.entity.Post;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    /*
    获得帖子
     */
    @PostMapping("/getPosts")
    public List<Post> getUser(){

        return postService.find();
    }

    /*
    根据id查帖子
     */
    @PostMapping("/post_id")
    public Result<Post> getUsers(@RequestBody Map<String, Long> request){

        Long post_id= request.get("post_id");
        log.info("根据id查帖子: {}", post_id);
        Post post= postService.getById(post_id);
        return Result.success(post);
    }


    @PostMapping("/createPost")
    public Result savePost(@RequestBody PostDTO postDTO){

        log.info("新增帖子:{}", postDTO);
        postService.savePost(postDTO);
        return Result.success();
    }

    /*
     * 删除帖子
     * deletePost
     * 请求参数：
     * {
     *   post_id: Number  // 要删除的帖子ID
     * }
     *
     * 响应参数：
     * {
     *   message: String  // 删除成功提示信息
     * }
     *
     */
    @PostMapping("/deletePost")
    public  String deletePost(@RequestBody Map<String, Object> request) {

        try {
            long post_id = ((Number) request.get("post_id")).longValue();

            log.info("根据id删除帖子: {}", post_id);
            postService.deletePost(post_id);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }

    }
    /*
     * 获取帖子详情
     * fetchPostsDetails
     * 请求参数：
     * post_id: String  // 帖子ID,从postList组件中获取
     * 响应参数：
     * title: String  // 帖子标题
     * message: String  // 帖子内容
     * post_partition: String  // 帖子分区
     * created_at: String  // 帖子创建时间
     * updated_at: String  // 帖子更新时间
     */
    @PostMapping("/fetchPostsDetails")
    public  Post fetchPostsDetails(@RequestBody Map<String, Object> request) {



            long post_id = ((Number) request.get("post_id")).longValue();
            log.info("根据id获取帖子详情: {}", post_id);
            return postService.fetchPostsDetails(post_id);

    }
    /*
     * 点赞要实现数据库的帖子点赞数加1，更新点赞数，需要后端接口支持。
     * handleLikes1
     * 请求参数：
     * post_id: String  // 帖子ID,从postList组件中获取
     * 响应参数：
     * success: Boolean  // 是否点赞成功
     * likes: Number  // 帖子点赞数
     */
    @PostMapping("/handleLikes1")
    public  int handleLikes1(@RequestBody Map<String, Object> request) {

        try {
            long post_id = ((Number) request.get("post_id")).longValue();



                log.info("根据id响应点赞数量: {}", post_id);
            int likes= postService.handleLikes1(post_id);
            return likes;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 点赞评论
     *   likeComment
     * 请求参数:
     * post_comment_id: String
     *
     * 响应参数:
     * likes: 点赞数+1
     */

    @PostMapping("/likeComment")
    public  int likeComment(@RequestBody Map<String, Object> request) {

        try {
            long post_comment_id = ((Number) request.get("post_comment_id")).longValue();

            log.info("根据id点赞数+1: {}", post_comment_id);
            int likes= postService.likeComment(post_comment_id);
            return likes;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 删除评论
     *   deleteComment
     * 请求参数:
     * post_comment_id: String
     *
     * 响应参数:
     * 无需返回具体数据，评论将被删除
     */
    @DeleteMapping("/deleteComment")
    public  String deleteComment(@RequestBody Map<String, Object> request) {
        try {
            long post_comment_id = ((Number) request.get("post_comment_id")).longValue();

            log.info("根据id删除评论: {}", post_comment_id);
            postService.deleteComment(post_comment_id);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }

    }
    /*
     * 更新帖子
     * updatePost
     * 请求参数：
     * {
     *   post_id: Number,  // 要更新的帖子ID
     *   title: String,    // 标题（必需）
     *   message: String   // 内容（必需）
     * }
     *
     * 响应参数：
     * 是否更新成功，无响应参数
     */
    @PostMapping("/updatePost")
    public String updatePost(@RequestBody UpdatePostDTO updatePostDTO) {


        try {
            log.info("根据id更新帖子:{}", updatePostDTO);
            postService.updatePost(updatePostDTO);
            return "更新帖子成功";
        } catch (Exception e) {
            return "更新帖子失败";
        }

    }

    //帖子点赞数加一
    @PostMapping("/likeComment4")
    public  int likeComment4(@RequestBody Map<String, Object> request) {

        try {
            long post_id= ((Number) request.get("post_id")).longValue();

            log.info("根据id帖子点赞数+1: {}", post_id);
            int likes= postService.likeComment4(post_id);
            return likes;
        }catch (Exception e){
            return 0;
        }

    }
    /*
     * 获取评论列表
     * fetchComments
     * 请求参数：
     *  post_id: String
     *  user_id:String
     * 响应参数：
     * comments:[{
     *    post_comment_id,
     *    username,
     *    content,
     *    likes,
     *    avatar,
     * },...],
     * userComments:[]  (用户在这个帖子评论区里发表的所有评论的id)
     *
     */
    @PostMapping("/fetchComments")
    public CommentsVO fetchComments(@RequestBody Map<String, Object> request) {

        long post_id = ((Number) request.get("post_id")).longValue();
        long user_id = ((Number) request.get("user_id")).longValue();
        log.info("根据id获取评论列表,用户在这个帖子评论区里发表的所有评论的id: {},{}", post_id,user_id);
        return postService.fetchComments(post_id,user_id);
    }
}
