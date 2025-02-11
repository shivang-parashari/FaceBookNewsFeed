package com.example.demo.Strategy;

import com.example.demo.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class NumberOfComment {

    public static void sortByComment(List<Post> posts){
        posts.sort(Comparator.comparingInt(Post::getNoOfComments));
    }

}
