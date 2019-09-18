package com.collabera.board.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Discussion {
	
	
	@Id
	private String id;
	
	@Indexed
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
