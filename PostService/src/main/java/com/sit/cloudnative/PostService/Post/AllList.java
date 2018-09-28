package com.sit.cloudnative.PostService.Post;

import java.util.Date;
import java.util.List;

import com.sit.cloudnative.PostService.Comment.Comment;
import com.sit.cloudnative.PostService.UserAdapter.User;

public class AllList {
    private long id;
    private String title;
    private String description;
    private User user;
    private List<Comment> comment;
    private Date createdAt;

    public AllList() {
    }

    public AllList(long id, String title, String description, User user, List<Comment> comment, Date createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComment() {
        return this.comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
