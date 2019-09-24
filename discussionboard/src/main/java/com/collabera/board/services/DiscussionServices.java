package com.collabera.board.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.board.models.Discussion;
import com.collabera.board.models.DiscussionChannel;
import com.collabera.board.repositories.DiscussionChannelRepo;

@Service
public class DiscussionServices {

	@Autowired
	private DiscussionChannelRepo repo;

	public List<Discussion> getList(String channelId) {
		// TODO Auto-generated method stub
		return this.repo.findById(channelId).get().getDiscussionsInChannel();
	}

	public List<Discussion> serachForDiscussion(String title) {

		List<Discussion> massList = new ArrayList<Discussion>();
		StringBuffer buff = new StringBuffer(title);

		CharSequence test = buff.subSequence(0, title.length());
		repo.findAll().forEach(channel -> channel

				.getDiscussionsInChannel().forEach(disc -> {

					if (disc.getDiscussionTitle().contains(test)) {
						massList.add(disc);
					}
				}));

		return massList;
	}

	public Discussion addItem(String channelId, Discussion disc) {
		DiscussionChannel channel = this.repo.findById(channelId).get();
		channel.getDiscussionsInChannel().add(disc);
		channel = this.repo.save(channel);
		Discussion addedDiscussion = channel.getDiscussionsInChannel().get(
				channel.getDiscussionsInChannel().size()-1
				);
		return addedDiscussion;
	}

	public Discussion deleteItem(String channelId, String discussionId) {
		DiscussionChannel channel = this.repo.findById(channelId).get();

		Discussion d = channel.getDiscussionsInChannel().stream()
				.filter(discussion -> discussion.getId().equals(discussionId)).findFirst().get();

		channel.getDiscussionsInChannel().remove(d);

		return d;
	}

	public Discussion updateItem(String channelId, String discussionId, Discussion entity) {
		DiscussionChannel channel = this.repo.findById(channelId).get();

		Discussion d = channel.getDiscussionsInChannel().stream()
				.filter(discussion -> discussion.getId().equals(discussionId)).findFirst().get();
		
		d.setDiscussionTitle(entity.getDiscussionTitle());
		d.setArticleContent(entity.getArticleContent());
		repo.save(channel);
		return d;
	}

}
