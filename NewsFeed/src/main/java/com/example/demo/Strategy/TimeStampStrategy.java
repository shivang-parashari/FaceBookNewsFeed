package com.example.demo.Strategy;

import com.example.demo.model.Post;

import java.util.Comparator;
import java.util.List;

public class TimeStampStrategy {


 public static void sortByDate(List<Post> posts) {
     posts.sort(new Comparator<Post>() {

         @Override
         public int compare(Post o1, Post o2) {
             return o1.getDate().compareTo(o2.getDate());
         }
     });
 }

}
