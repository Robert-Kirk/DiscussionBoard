package com.collabera.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.collabera.board.models.Discussion;
import com.collabera.board.repositories.DiscussionRepo;
import com.collabera.board.services.interfaces.BasicCrudServices;

public class DiscussionServices implements BasicCrudServices<Discussion> {
	
	@Autowired
	private DiscussionRepo repo;

	@Override
	public List<Discussion> getList() {
		// TODO Auto-generated method stub
		return this.repo.getList();
	}

	@Override
	public List<Discussion> getList(String title) {
		
		return this.repo.getList(title);
	}

	@Override
	public Discussion addItem(Discussion disc) {
		return this.repo.addItem(disc);
	}

	@Override
	public Discussion deleteItem(int id) {
		return this.repo.deleteItem(id);
	}

	@Override
	public Discussion updateItem(int id) {
		return this.repo.updateItem(id);
	}


}
