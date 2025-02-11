package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

import java.util.ArrayList;
import java.util.List;

public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public String addPost(Post post) {
        try{
            this.postService.save(post);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    public List<Post> getAllPosts(String username) {
        List<Post> posts = new ArrayList<>();
        try{
            return this.postService.findAllPosts(username);
        }catch (Exception e){
            return posts;
        }
    }

    public void upvotePost(int postId) {
         this.postService.upvote(postId);
    }

    public void downvotePost(int postId) {
        this.postService.downvote(postId);
    }



}
