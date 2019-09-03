package com.collabera.board.models;

import java.util.List;

import com.collabera.board.models.interfaces.SiteContent;

public class Discussion {
	
	private String discussionTitle;
	private String author;
	private SiteContent articleContent;
	
	@SuppressWarnings("unused")
	private List<CommentTrees> comments;

	public Discussion() {}

	public String getDiscussionTitle() {
		return discussionTitle;
	}

	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public SiteContent getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(SiteContent articleContent) {
		this.articleContent = articleContent;
	}
	
	
	
	

}
