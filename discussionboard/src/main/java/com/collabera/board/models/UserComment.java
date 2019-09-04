package com.collabera.board.models;

import com.collabera.board.models.interfaces.SiteContent;

public class UserComment {
	
	
	private String userThatMadePost;
	private SiteContent commentContent;

	public UserComment() {}

	public String getUserThatMadePost() {
		return userThatMadePost;
	}

	public void setUserThatMadePost(String userThatMadePost) {
		this.userThatMadePost = userThatMadePost;
	}

	public SiteContent getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(SiteContent commentContent) {
		this.commentContent = commentContent;
	}

}
