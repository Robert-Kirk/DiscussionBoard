package com.collabera.board.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DiscussionChannel {

	@Id
	private String id;

	@Indexed
	private String title;

	private List<Discussion> discussions;

//	private List<Role> channelRoles;	

	private String dateCreated;

	public DiscussionChannel() {
	}

	public String getChannelName() {
		return title;
	}

	public void setChannelName(String channelName) {
		this.title = channelName;
	}

	public List<Discussion> getDiscussionsInChannel() {
		return discussions;
	}

	public void setDiscussionsInChannel(List<Discussion> discussionsInChannel) {
		this.discussions = discussionsInChannel;
	}

//	public List<Role> getChannelRoles() {
//		return channelRoles;
//	}
//
//
//
//	public void setChannelRoles(List<Role> channelRoles) {
//		this.channelRoles = channelRoles;
//	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

}
