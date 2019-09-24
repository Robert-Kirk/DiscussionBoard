package com.collabera.board.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collabera.board.models.Discussion;

@Deprecated
@Repository
public interface DiscussionRepo extends MongoRepository<Discussion, String> {

	List<Discussion> findAllByTitle(String title);

}
