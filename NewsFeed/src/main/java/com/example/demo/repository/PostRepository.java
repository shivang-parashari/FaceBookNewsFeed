package com.example.demo.repository;

import com.example.demo.model.Post;

import java.util.ArrayList;

public class PostRepository {

    ArrayList<Post> posts;

    public PostRepository() {
        posts = new ArrayList<>();
    }

    public ArrayList<Post> getPostsUserName(String username) {
        ArrayList<Post> postList = new ArrayList<>();
        for (Post post : posts) {
            if (username.equals(post.getUserName())) {
               postList.add(post);
            }
        }
        return postList;
    }

    public void addPost(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    public void upvote(int postId) {
        for (Post post : posts) {
            if (postId == post.getId()) {
                post.setUpvoteCount(post.getUpvoteCount() + 1);
            }
        }
    }

    public void downvote(int postId) {
        for (Post post : posts) {
            if (postId == post.getId()) {
                post.setDownvoteCount(post.getDownvoteCount() + 1);
            }
        }
    }
}
