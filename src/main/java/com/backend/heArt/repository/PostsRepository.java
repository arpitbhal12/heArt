package com.backend.heArt.repository;

import com.backend.heArt.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Post, String> {

}
