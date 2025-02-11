package com.example.demo.Strategy;


import com.example.demo.model.Post;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
public class ScoreStrategyOrder {

    private String userName;


    public static void compareByScore(List<Post> posts) {

        posts.sort(new Comparator<Post>() {

            @Override
            public int compare(Post P1, Post P2) {
                int voteDiff = P1.getUpvoteCount() - P1.getDownvoteCount();
                int voteDiff2 = P2.getUpvoteCount() - P2.getDownvoteCount();

                return Integer.compare(voteDiff2, voteDiff);

            }

        });

        System.out.println(posts);

    }




}
