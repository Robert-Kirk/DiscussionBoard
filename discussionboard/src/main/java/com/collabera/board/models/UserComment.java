package com.collabera.board.models;

import java.util.List;

import com.collabera.board.models.interfaces.SiteContent;

public class UserComment {
	
	
	private String userThatMadePost;
	private SiteContent commentContent;
	
	//Implements tree based logic where comments that are replies ot other comments start a new layer.
	private List<UserComment> responses;

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

	public List<UserComment> getResponses() {
		return responses;
	}

	public void setResponses(List<UserComment> responses) {
		this.responses = responses;
	}	

}
