package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

import java.util.List;

public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public String addComment(Comment comment) throws Exception {
        try{
            this.commentService.saveComment(comment);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    public List<Comment> getCommentList(int postId) throws Exception {

        try{
            return this.commentService.findAllComment(postId);
        }catch (Exception e){
            return null;
        }
    }
}
