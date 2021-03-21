package com.backend.heArt.repository;

import com.backend.heArt.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends MongoRepository<Comment, String> {
    public List<Comment> getCommentsByPostId(String id);
    Optional<Comment> findById(String id);

    @Query("{ 'id' : ?0 }")
    Comment getCommentById(String id);
}
