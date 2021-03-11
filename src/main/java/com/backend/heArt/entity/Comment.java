package com.backend.heArt.entity;

public class Comment {

    private Long userId;

    private String userName;

    private String commentText;

    private Integer likeCount;

    public Comment(Long userId, String userName, String commentText, Integer likeCount) {
        this.userId = userId;
        this.userName = userName;
        this.commentText = commentText;
        this.likeCount = likeCount;
    }
}
