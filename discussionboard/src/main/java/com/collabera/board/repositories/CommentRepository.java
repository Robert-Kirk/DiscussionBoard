package com.collabera.board.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.board.models.Comment;


@Deprecated
public interface CommentRepository extends MongoRepository<Comment, String> {
	
	
	
}
