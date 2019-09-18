package com.collabera.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.collabera.board.models.DiscussionChannel;
import com.collabera.board.repositories.DiscussionChannelRepo;
import com.collabera.board.services.interfaces.BasicCrudServices;

public class DiscussionChannelServices implements BasicCrudServices<DiscussionChannel>{

	@Autowired
	DiscussionChannelRepo repo;
	
	@Override
	public List<DiscussionChannel> getList() {
		
		return repo.findAll();
	}
	
	@Override
	public List<DiscussionChannel> getList(String title) {
		// TODO Auto-generated method stub
		return repo.findAllByTitle(title);
	}

	@Override
	public DiscussionChannel addItem(DiscussionChannel channel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscussionChannel deleteItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscussionChannel updateItem(Long id, DiscussionChannel channel) {
		// TODO Auto-generated method stub
		return null;
	}

}
