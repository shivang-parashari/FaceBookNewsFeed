package com.example.demo.repository;

import com.example.demo.model.Comment;

import java.util.ArrayList;

public class CommentRepository {

    ArrayList<Comment> comments;

    public CommentRepository() {
        comments = new ArrayList<>();
    }

    public ArrayList<Comment> getCommentsByPostId(int postId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getPostId() == postId) {
                comments.add(comment);
            }
        }
        return comments;
    }

    public void addComment(Comment comment) {
        comment.setId(comments.size() + 1);
        comments.add(comment);
    }

}
