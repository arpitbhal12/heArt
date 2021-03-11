package com.backend.heArt.service;

import com.backend.heArt.entity.Post;
import com.backend.heArt.repository.PostsRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedService implements GraphQLQueryResolver {

    @Autowired
    PostsRepository postsRepository;

    public List<Post> showFeed() {
        List<Post> posts = postsRepository.findAll();
        return posts;
    }

    public void savePost(Post post) {
        postsRepository.save(post);
        return;
    }

}
