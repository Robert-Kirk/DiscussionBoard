package com.collabera.board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.collabera.board.models.Comment;
import com.collabera.board.models.Discussion;
import com.collabera.board.services.CommentServices;

public class CommentController {

	@Autowired
	CommentServices services;

//	// 1. List some channels
//	@GetMapping("/")
//	public List<Comment> listAllComments() {
//		return services.getList();
//	}
//
//	// 1.1. Filter list of channels
//	@GetMapping("/{title}")
//	public List<Comment> listFilteredCommentsList(@PathVariable(value = "title") String title) {
//		return services.getList(title);
//
//	}

	// 1.2. Navigate to specific channel

//	@GetMapping("/{name}/home")
//	public String redirectToSpecificComment(@PathVariable String name) {
//		return name;
//
//	}

	// 2. add channel
	@PostMapping("{discussionId}")
	public Discussion addComment(@PathVariable(value = "discussionId") String discussionId,
			@RequestBody Comment channel) {

		return services.addItem(discussionId, channel);

	}

	@PostMapping("{discussionId}/{replyId}")
	public Discussion addComment(@PathVariable(value = "discussionId") String discussionId,
			@RequestBody Comment channel, @PathVariable(value = "replyId") String replyId) {

		return services.addItem(discussionId, channel, replyId);

	}

	// 3. update channel
	@PutMapping("{discussionId}/{commentId}")
	public Discussion updateComment(@PathVariable(value = "discussionId") String discussionId,
			@RequestBody Comment channel, @PathVariable(value = "commentId") String commentId) {
		return services.updateItem(discussionId, commentId, channel);

	}

	// 4. delete channel
	// SoftDelete
	@PutMapping("{discussionId}/{commentId}")
	public Discussion deleteComment(@PathVariable(value = "discussionId") String discussionId,
			@PathVariable(value = "commentId") String commentId) {
		return services.deleteItem(discussionId, commentId);

	}

}
