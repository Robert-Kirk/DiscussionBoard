package com.collabera.board.models;

import java.sql.Date;

import com.collabera.board.models.interfaces.String;

public class UpdateLog {
	//Primary Key id
	private int id;
	//sudo Foreign key Title
	private String uniqueStringId;
	private Date dateOfTheUpdate;
	
	//TODO Consider class: Content for this to read changes
	private String contentOfTheUpdate;

	
	
	
	public UpdateLog() {}

	public String getNameOfUserThatUpdated() {
		return uniqueStringId;
	}

	public void setNameOfUserThatUpdated(String nameOfUserThatUpdated) {
		this.uniqueStringId = nameOfUserThatUpdated;
	}

	public Date getDateOfTheUpdate() {
		return dateOfTheUpdate;
	}

	public void setDateOfTheUpdate(Date dateOfTheUpdate) {
		this.dateOfTheUpdate = dateOfTheUpdate;
	}

	public String getContentOfTheUpdate() {
		return contentOfTheUpdate;
	}

	public void setContentOfTheUpdate(String contentOfTheUpdate) {
		this.contentOfTheUpdate = contentOfTheUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
