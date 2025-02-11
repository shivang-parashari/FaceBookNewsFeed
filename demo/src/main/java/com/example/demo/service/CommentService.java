package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment) throws Exception {
        try{
            this.commentRepository.addComment(comment);
        }catch (Exception e){
            throw new Exception("unable to save comment");
        }
    }
    public List<Comment> findAllComment(int postid) throws Exception {
        List<Comment> comments = new ArrayList<>();

        try{
            comments = this.commentRepository.getCommentsByPostId(postid);
        }catch (Exception e){
            throw new Exception("unable to get comments");
        }
        return comments;
    }
}
