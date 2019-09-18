package com.collabera.board.models;

import java.util.List;

public class CommentTrees {
	
	private List<UserComment> comments;

	public CommentTrees() {}

	public List<UserComment> getComments() {
		return comments;
	}

	public void setComments(List<UserComment> comments) {
		this.comments = comments;
	} 

}
