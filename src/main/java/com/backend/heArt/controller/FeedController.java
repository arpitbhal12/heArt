package com.backend.heArt.controller;

import com.backend.heArt.entity.Post;
import com.backend.heArt.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    FeedService feedService;

    @GetMapping("/all")
    public List<Post> showFeeds() throws Exception {
        List<Post> posts = this.feedService.showFeed();
        return posts;
    }
}
