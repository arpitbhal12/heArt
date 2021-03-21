package com.backend.heArt.service.resolver;

import com.backend.heArt.entity.Comment;
import com.backend.heArt.entity.Post;
import com.backend.heArt.repository.CommentsRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentResolver implements GraphQLResolver {
    @Autowired
    CommentsRepository commentsRepository;

    public List<Comment> commentList(Post post){
        System.out.println("dmnjfefn00");
        return commentsRepository.getCommentsByPostId(post.getId());
    }
}
