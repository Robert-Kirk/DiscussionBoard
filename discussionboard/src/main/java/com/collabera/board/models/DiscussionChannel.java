package com.collabera.board.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="channel")
public class DiscussionChannel {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String channelName;

	private List<Discussion> discussionsInChannel;

	private List<Role> channelRoles;

	private Date dateCreated;

	private boolean viewable;

	public DiscussionChannel() {
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public List<Discussion> getDiscussionsInChannel() {
		return discussionsInChannel;
	}

	public void setDiscussionsInChannel(List<Discussion> discussionsInChannel) {
		this.discussionsInChannel = discussionsInChannel;
	}

	public List<Role> getChannelRoles() {
		return channelRoles;
	}

	public void setChannelRoles(List<Role> channelRoles) {
		this.channelRoles = channelRoles;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isViewable() {
		return viewable;
	}

	public void setViewable(boolean viewable) {
		this.viewable = viewable;
	}

}
