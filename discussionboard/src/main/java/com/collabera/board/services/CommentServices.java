package com.collabera.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.board.models.Comment;
import com.collabera.board.models.Discussion;
import com.collabera.board.models.DiscussionChannel;
import com.collabera.board.repositories.DiscussionChannelRepo;

@Service
public class CommentServices {

	@Autowired
	private DiscussionChannelRepo repo;

//	@Autowired
//	DiscussionRepo discussionRep;

//	@Autowired
//	CommentRepository repo;

//	@Deprecated
//	public List<Comment> getList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Deprecated
//	public List<Comment> getCommentsByAuthor(String author) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public Discussion addItem(String channelId, String discussionId, Comment comment) {
		DiscussionChannel targetChannel = getTargetChannel(channelId);

		Discussion targetDiscussion = getTargetedDiscussion(discussionId, targetChannel);

		targetDiscussion.getComments().add(comment);
		repo.save(targetChannel);
		return targetDiscussion;
	}

	public Discussion addItem(String channelId, String discussionId, Comment comment, String replyId) {
		DiscussionChannel targetChannel = getTargetChannel(channelId);

		Discussion targetDiscussion = getTargetedDiscussion(discussionId, targetChannel);

		comment.setReplyId(replyId);
		targetDiscussion.getComments().add(comment);
		repo.save(targetChannel);
		return targetDiscussion;
	}

	public Discussion deleteItem(String channelId, String discussionId, String commentId) {
		DiscussionChannel targetChannel = getTargetChannel(channelId);

		Discussion targetDiscussion = getTargetedDiscussion(discussionId, targetChannel);

		List<Comment> commsSearch = targetDiscussion.getComments();

		commsSearch.removeIf(comment -> comment.getId().equals(commentId));
		repo.save(targetChannel);
		return targetDiscussion;
	}

	public Discussion updateItem(String channelId, String discussionId, String commentId, Comment comment) {
		DiscussionChannel targetChannel = getTargetChannel(channelId);

		Discussion targetDiscussion = getTargetedDiscussion(discussionId, targetChannel);
		
		List<Comment> comments = targetDiscussion.getComments();

		int index = comments.indexOf(comments.stream()
				.filter(commentBeingProcessed -> commentBeingProcessed.getId().equals(commentId)).findFirst().get());
		String orginalId = comments.get(index).getId();
		comments.remove(index);
		comment.setId(orginalId);
		comments.add(index, comment);

		repo.save(targetChannel);
		
		return targetDiscussion;
	}

	private Discussion getTargetedDiscussion(String discussionId, DiscussionChannel channel) {
		return channel.getDiscussionsInChannel().stream().filter(discussion -> discussion.getId().equals(discussionId))
				.findFirst().get();
	}

	private DiscussionChannel getTargetChannel(String channelId) {
		return repo.findById(channelId).get();
	}

}
