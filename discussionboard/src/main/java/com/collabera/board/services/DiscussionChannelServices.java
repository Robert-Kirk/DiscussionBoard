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
		return repo.getAllChannels();
	}
	
	@Override
	public List<DiscussionChannel> getList(String title) {
		return repo.getChannelsByName(title);
	}

	@Override
	public DiscussionChannel addItem(DiscussionChannel channel) {
		return repo.save(channel);
	}

	@Override
	public DiscussionChannel deleteItem(Long id) {
		DiscussionChannel channel = repo.getOne(id);
		repo.deleteById(id);
		return channel;
	}

	@Override
	public DiscussionChannel updateItem(DiscussionChannel channel) {
		return repo.save(channel);
	}

}
