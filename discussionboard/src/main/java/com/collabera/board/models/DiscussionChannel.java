package com.collabera.board.models;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DiscussionChannel {
	
	@Id
	private String id;
	
	@Indexed
	private String channelName;
	
	private List<Discussion> discussionsInChannel;
	
	private List<Role> channelRoles;	
	
	private Date dateCreated;
	
	
	
	/*
	 * Update Tracking properties contains logs for of the channels updates
	 * 
	 * name of the user committing the update
	 * Date it occurred. Probably should include Time?
	 * List of updates
	 * 
	 * made to keep track of changes for administrative  purposes.
	 */
	private UpdateTracker updateTracker;



	public DiscussionChannel() {}



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



	public UpdateTracker getUpdateTracker() {
		return updateTracker;
	}



	public void setUpdateTracker(UpdateTracker updateTracker) {
		this.updateTracker = updateTracker;
	}
	
	
	

}
