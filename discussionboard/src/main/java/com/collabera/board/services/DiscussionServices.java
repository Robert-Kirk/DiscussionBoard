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
		return this.repo.findAll();
	}

	@Override
	public List<Discussion> getList(String title) {
		return this.repo.findAllByTitle(title);
	}

	@Override
	public Discussion addItem(Discussion disc) {
		return this.repo.insert(disc);
	}

	@Override
	public Discussion deleteItem(Long id) {
		Discussion d = this.repo.findById(id).get();
		this.repo.deleteById(id);
		return d;
	}

	@Override
	public Discussion updateItem(Long id, Discussion entity) {
		return this.repo.save(entity);
	}


}
