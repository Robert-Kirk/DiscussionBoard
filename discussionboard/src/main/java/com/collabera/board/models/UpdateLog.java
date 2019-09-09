package com.collabera.board.models;

import java.sql.Date;

import com.collabera.board.models.interfaces.SiteContent;

public class UpdateLog {
	
	private int id;
	private String nameOfUserThatUpdated;
	private Date dateOfTheUpdate;
	
	//TODO Consider class: Content for this to read changes
	private SiteContent contentOfTheUpdate;

	
	
	
	public UpdateLog() {}

	public String getNameOfUserThatUpdated() {
		return nameOfUserThatUpdated;
	}

	public void setNameOfUserThatUpdated(String nameOfUserThatUpdated) {
		this.nameOfUserThatUpdated = nameOfUserThatUpdated;
	}

	public Date getDateOfTheUpdate() {
		return dateOfTheUpdate;
	}

	public void setDateOfTheUpdate(Date dateOfTheUpdate) {
		this.dateOfTheUpdate = dateOfTheUpdate;
	}

	public SiteContent getContentOfTheUpdate() {
		return contentOfTheUpdate;
	}

	public void setContentOfTheUpdate(SiteContent contentOfTheUpdate) {
		this.contentOfTheUpdate = contentOfTheUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
