package com.backend.heArt.entity;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Document(collection = "Posts")
public class Post {

    @Id
    private String id;

    private String title;

    private Long userId;

    private String userName;

    private String contentText;

    private Integer likeCount;

    @Indexed(direction = IndexDirection.DESCENDING)
    private Date date;

    private List<Comment> commentList;

    public Post(String title, Long userId, String userName, String contentText, int likeCount, Date date, List<Comment> commentList) {
        this.title = title;
        this.userId = userId;
        this.userName = userName;
        this.contentText = contentText;
        this.likeCount = likeCount;
        this.date = date;
        this.commentList = commentList;
    }

}
