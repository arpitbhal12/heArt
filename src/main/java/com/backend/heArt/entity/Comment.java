package com.backend.heArt.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Comments")
@Getter
@Setter
public class Comment {
    @Id
    private String id;

    private String postId;

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
