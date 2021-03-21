package com.backend.heArt.repository;

import com.backend.heArt.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Post, String> {
    @Query("{ 'id' : ?0 }")
    Post getPostById(String id);
}
