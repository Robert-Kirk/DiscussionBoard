package com.collabera.board.services.interfaces;

import java.util.List;

import com.collabera.board.models.DiscussionChannel;

public interface BasicCrudServices<T> {
	
	public List<T> getList();

	public List<T> getList(String title);

	public T addItem(T t);

	public T deleteItem(int id);

	public T updateItem(int id);

}
