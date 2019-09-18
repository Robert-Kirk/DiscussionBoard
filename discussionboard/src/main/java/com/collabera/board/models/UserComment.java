package com.collabera.board.models;

public class UserComment {
	
	
	private String userThatMadePost;
	private String commentContent;

	public UserComment() {}

	public String getUserThatMadePost() {
		return userThatMadePost;
	}

	public void setUserThatMadePost(String userThatMadePost) {
		this.userThatMadePost = userThatMadePost;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

}
