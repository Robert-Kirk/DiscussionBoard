package com.collabera.board.services.interfaces;

import java.util.List;

public interface BasicCrudServices<T> {
	
	public List<T> getList();

	public List<T> getList(String title);

	public T addItem(T t);

	public T deleteItem(Long id);

	public T updateItem(T t);

}
