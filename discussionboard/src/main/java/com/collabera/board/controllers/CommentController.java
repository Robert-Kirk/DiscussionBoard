package com.collabera.board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.board.models.Comment;
import com.collabera.board.models.Discussion;
import com.collabera.board.services.CommentServices;

import io.swagger.annotations.Api;

@RestController
@Api(value="Comment Controller")
@RequestMapping("/channels/{channelId}/{discussionId}")
public class CommentController {

	@Autowired
	CommentServices commentControllerServices;

	// 2. add channel
	@PostMapping("/")
	public Discussion addComment(@PathVariable(value = "channelId") String channelId,
			@PathVariable(value = "discussionId") String discussionId,
			@RequestBody Comment comment) {

		return commentControllerServices.addItem(channelId, discussionId, comment);

	}

	@PostMapping("/{replyId}")
	public Discussion addComment(@PathVariable(value = "channelId") String channelId,
			@PathVariable(value = "discussionId") String discussionId,
			@RequestBody Comment channel, @PathVariable(value = "replyId") String replyId) {

		return commentControllerServices.addItem(channelId, discussionId, channel, replyId);

	}

	// 3. update channel
	@PutMapping("/{commentId}")
	public Discussion updateComment(@PathVariable(value = "channelId") String channelId,
			@PathVariable(value = "discussionId") String discussionId,
			@RequestBody Comment channel, @PathVariable(value = "commentId") String commentId) {
		return commentControllerServices.updateItem(channelId, discussionId, commentId, channel);

	}

	// 4. delete channel
	// Hard Delete
	@DeleteMapping("/{commentId}")
	public Discussion deleteComment(@PathVariable(value = "channelId") String channelId,
			@PathVariable(value = "discussionId") String discussionId,
			@PathVariable(value = "commentId") String commentId) {
		return commentControllerServices.deleteItem(channelId, discussionId, commentId);

	}

}
