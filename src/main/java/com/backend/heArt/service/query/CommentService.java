package com.backend.heArt.service.query;

import com.backend.heArt.entity.Comment;
import com.backend.heArt.repository.CommentsRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements GraphQLQueryResolver {
    @Autowired
    CommentsRepository commentsRepository;

    public Comment getComment(String id) {
        System.out.println("dfjhkf00");
        return commentsRepository.getCommentById(id);
    }
}
