package com.example.demo.service;

import com.example.demo.Strategy.NumberOfComment;
import com.example.demo.Strategy.ScoreStrategyOrder;
import com.example.demo.Strategy.TimeStampStrategy;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.model.UserFriend;
import com.example.demo.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    private PostRepository postRepository;
    private UserFriendsService userFriendsService;

    public PostService(PostRepository postRepository, UserFriendsService userFriendsService) {
        this.postRepository = postRepository;
        this.userFriendsService = userFriendsService;
    }

    public void save(Post post) throws Exception {
        try{
            this.postRepository.addPost(post);
        }catch (Exception e){
            throw new Exception("unable to save post");
        }
    }

    public List<Post> findAllPosts(String userName) throws Exception {
        List<Post> posts = new ArrayList<>();
        try{
            List<UserFriend> userFriends = userFriendsService.getUserFriends(userName);

            for (UserFriend userFriend : userFriends) {
                List<Post> friendPost;

                friendPost = this.postRepository.getPostsUserName(userFriend.getFriendName());

                posts.addAll(friendPost);
            }

            TimeStampStrategy.sortByDate(posts);
            NumberOfComment.sortByComment(posts);
            ScoreStrategyOrder.compareByScore(posts);


            return posts;
        }catch (Exception e){
            throw new Exception("unable to find posts");
        }
    }

    public void upvote(int postId)  {
        this.postRepository.upvote(postId);
    }

    public void downvote(int postId)  {
        this.postRepository.downvote(postId);
    }


}
