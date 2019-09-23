package com.collabera.board.services.interfaces;

import java.util.List;

@Deprecated
public interface BasicCrudServices<T> {

	public List<T> getList();

	public List<T> getList(String title);

	public T addItem(T t);

	public T deleteItem(String id);

	public T updateItem(String id, T t);

}
