package com.collabera.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.collabera.board.models.Discussion;
import com.collabera.board.repositories.DiscussionRepo;
import com.collabera.board.services.interfaces.BasicCrudServices;

public class DiscussionServices implements BasicCrudServices<Discussion> {

	@Autowired
	DiscussionRepo repo;
	
	@Override
	public List<Discussion> getList() {
		return repo.getAllDiscussions();
	}

	@Override
	public List<Discussion> getList(String title) {
		return repo.getDiscussionsByName(title);
	}

	@Override
	public Discussion addItem(Discussion disc) {
		// TODO Auto-generated method stub
		return repo.save(disc);
	}

	@Override
	public Discussion deleteItem(Long id) {
		Discussion disc = repo.findById(id).get();
		repo.deleteById(id);
		return disc;
	}

	@Override
	public Discussion updateItem(Discussion desc) {
		// TODO Auto-generated method stub
		return repo.save(desc);
	}


}
