package com.collabera.board.models;

import java.sql.Date;
import java.util.List;

public class UpdateTracker {
	
	private Date dateLastUpdated;
	private String lastUserToUpdate;
	private List<UpdateLog> updateLogs;
	
	
	public UpdateTracker() {
	}


	public Date getDateLastUpdated() {
		return dateLastUpdated;
	}


	public void setDateLastUpdated(Date dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}


	public String getLastUserToUpdate() {
		return lastUserToUpdate;
	}


	public void setLastUserToUpdate(String lastUserToUpdate) {
		this.lastUserToUpdate = lastUserToUpdate;
	}


	public List<UpdateLog> getUpdateLogs() {
		return updateLogs;
	}


	public void setUpdateLogs(List<UpdateLog> updateLogs) {
		this.updateLogs = updateLogs;
	}
	
	

}
