package com.collabera.board.models;

import java.util.List;

import com.collabera.board.models.interfaces.String;

public class Discussion {
	
	private String discussionTitle;
	private String author;
	private String articleContent;
	
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

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	
	
	

}
