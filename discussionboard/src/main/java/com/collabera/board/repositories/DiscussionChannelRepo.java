package com.collabera.board.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collabera.board.models.DiscussionChannel;

@Repository
public interface DiscussionChannelRepo extends MongoRepository<DiscussionChannel, String> {

	List<DiscussionChannel> findAllByTitle(String title);

	List<DiscussionChannel> findAllBy(TextCriteria criteria);




}
