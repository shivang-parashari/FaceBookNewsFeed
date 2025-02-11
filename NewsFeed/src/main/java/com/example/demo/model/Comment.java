package com.example.demo.model;


import java.util.Date;


public class Comment extends Base {

    private String content;

    private String userName;

    private Date createTime;

    private int postId;

    public String getContent() {
        return this.content;
    }

    public String getUserName() {
        return this.userName;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
