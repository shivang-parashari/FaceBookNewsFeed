package com.example.demo.model;


import java.util.Date;


public class Post extends Base {

    private String title;

    private Date date;

    private int upvoteCount;

    private int downvoteCount;

    private String UserName;

    private int noOfComments;


    public String getTitle() {
        return this.title;
    }

    public Date getDate() {
        return this.date;
    }

    public int getUpvoteCount() {
        return this.upvoteCount;
    }

    public int getDownvoteCount() {
        return this.downvoteCount;
    }

    public String getUserName() {
        return this.UserName;
    }

    public int getNoOfComments() {
        return this.noOfComments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUpvoteCount(int upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public void setDownvoteCount(int downvoteCount) {
        this.downvoteCount = downvoteCount;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setNoOfComments(int noOfComments) {
        this.noOfComments = noOfComments;
    }
}
