package com.collabera.board.models;

import java.util.List;

@Deprecated
public class CommentTrees {
	
	private List<Comment> comments;

	public CommentTrees() {}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	} 

}
