package com.example.demo;

import com.example.demo.controller.CommentController;
import com.example.demo.controller.PostController;
import com.example.demo.controller.UserController;
import com.example.demo.controller.UserFriendsController;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserFriendsRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import com.example.demo.service.UserFriendsService;
import com.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {

        // User
        UserRepository users = new UserRepository();
        UserService userService = new UserService(users);
        UserController userController = new UserController(userService);

        // UserFriends
        UserFriendsRepository userFriends = new UserFriendsRepository();
        UserFriendsService userFriendsService = new UserFriendsService(userFriends);
        UserFriendsController userFriendsController = new UserFriendsController(userFriendsService);

        // Post
        PostRepository posts = new PostRepository();
        PostService postService = new PostService(posts, userFriendsService);
        PostController postController = new PostController(postService);

        // comment
        CommentRepository comments = new CommentRepository();
        CommentService commentService = new CommentService(comments);
        CommentController commentController = new CommentController(commentService);


        String currentUserLogin = null;
        String currentPostId = null;

        Scanner scanner = new Scanner(System.in);
        while(true){
            String userInput = scanner.nextLine();
            String[] inputParts = userInput.split("~");

            if (inputParts.length >= 2) {
                String action = inputParts[0].toLowerCase(); // Normalize action to lowercase for consistency
                String value = inputParts[1];

                // Use switch to handle the different actions
                switch (action) {
                    case "signup":
                        User newUser = new User();
                        newUser.setUserName(value);
                        newUser.setPassword(value + "@123");
                        userController.addUser(newUser);
                        break;

                    case "login":
                        if(userController.getUser(value) != null){
                            currentUserLogin = value;
                        }else {
                            System.out.println("Invalid username or password");
                        }
                        break;

                    case "post":
                        Post newPost = new Post();
                        newPost.setTitle(value);
                        newPost.setDate(new Date());
                        newPost.setDownvoteCount(0);
                        newPost.setUpvoteCount(0);
                        newPost.setUserName(currentUserLogin);
                        postController.addPost(newPost);
                        break;



                    case "follow":
                        String user = currentUserLogin;
                        String friend = inputParts[1];

                        System.out.println(userFriendsController.addUserFriend(user,friend));

                        break;

                    case "shownewsfeed":
                        List<Post> userPosts = new ArrayList<>();
                        userPosts = postController.getAllPosts(currentUserLogin);
                        for(Post post: userPosts){
                            System.out.println("id:" + post.getId());
                            System.out.println("title:" + post.getTitle());
                            System.out.println("date:" + post.getDate());
                            System.out.println("downvoteCount:" + post.getDownvoteCount());
                            System.out.println("upvoteCount:" + post.getUpvoteCount());
                        }
                        break;


                    case "reply":
                        Comment newComment = new Comment();
                        newComment.setContent(inputParts[2]);
                        newComment.setPostId(Integer.parseInt(inputParts[1]));
                        newComment.setUserName(currentUserLogin);
                        newComment.setCreateTime(new Date());
                        commentController.addComment(newComment);

                        break;


                    case "comments":
                        List<Comment> postComments = new ArrayList<>();
                        postComments = commentController.getCommentList(Integer.parseInt(value));
                        for(Comment comment: postComments){
                            System.out.println("id:" + comment.getId());
                            System.out.println("content:" + comment.getContent());
                            System.out.println("postId:" + comment.getPostId());
                            System.out.println("userName:" + comment.getUserName());
                            System.out.println("createTime:" + comment.getCreateTime());
                        }

                        break;



                    case "upvote":
                        postController.upvotePost(Integer.parseInt(value));
                        break;


                    case "downvote":
                        postController.downvotePost(Integer.parseInt(value));
                        break;

                    default:
                        System.out.println("Unknown action: " + action);
                }
            } else {
                System.out.println("Invalid input format.");
            }

        }
    }

}
