package com.collabera.board.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collabera.board.models.Discussion;

@Repository
public interface DiscussionRepo extends MongoRepository<Discussion, Long> {

	List<Discussion> findAllByTitle(String title);

}
