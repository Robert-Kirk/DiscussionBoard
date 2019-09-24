package com.collabera.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.collabera.board.models.DiscussionChannel;
import com.collabera.board.repositories.DiscussionChannelRepo;

@Service
public class DiscussionChannelServices{

	@Autowired
	DiscussionChannelRepo repo;
	
	
	public List<DiscussionChannel> getList() { 
		
		return repo.findAll();
	}
	
	
	public List<DiscussionChannel> getList(String title) {
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(title);
		return repo.findAllByTitle();
	}

	
	public DiscussionChannel addItem(DiscussionChannel channel) {
		
		return repo.save(channel);
	}

	
	public DiscussionChannel deleteItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DiscussionChannel updateItem(String id, DiscussionChannel channel) {
		DiscussionChannel old = repo.findById(id).get();
		
		old.setChannelName(channel.getChannelName());
		
		return repo.save(old); 
	}

}
