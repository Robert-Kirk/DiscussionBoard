package com.collabera.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.collabera.board.models.Comment;
import com.collabera.board.models.Discussion;
import com.collabera.board.repositories.DiscussionRepo;

public class CommentServices {

	@Autowired
	DiscussionRepo discussionRep;

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

	public Discussion addItem(String discussionId, Comment comment) {
		Discussion targetDisc = this.getTargetedDiscussion(discussionId);
		targetDisc.getComments().add(comment);

		return this.saveTargetDiscussion(targetDisc);
	}

	public Discussion addItem(String discussionId, Comment comment, String replyId) {
		Discussion targetDisc = this.getTargetedDiscussion(discussionId);
		comment.setReplyId(replyId);
		targetDisc.getComments().add(comment);

		return this.saveTargetDiscussion(targetDisc);
	}

	public Discussion deleteItem(String discussionId, String commentId) {
		Discussion targetDisc = this.getTargetedDiscussion(discussionId);

		List<Comment> commsSearch = targetDisc.getComments();

		commsSearch.removeIf(comment -> comment.getId().equals(commentId));

		return this.saveTargetDiscussion(targetDisc);
	}

	public Discussion updateItem(String discussionId, String commentId, Comment comment) {
		Discussion target = this.getTargetedDiscussion(discussionId);
		List<Comment> comments = target.getComments();

		int index = comments.indexOf(comments.stream()
				.filter(commentBeingProcessed -> commentBeingProcessed.getId().equals(commentId)).findFirst().get());
		String orginalId = comments.get(index).getId();
		comments.remove(index);
		comment.setId(orginalId);
		comments.add(index, comment);

		return this.saveTargetDiscussion(target);
	}

	private Discussion getTargetedDiscussion(String discussionId) {
		return discussionRep.findById(discussionId).get();
	}

	private Discussion saveTargetDiscussion(Discussion disc) {
		return discussionRep.save(disc);
	}

}
