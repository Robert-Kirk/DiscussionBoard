package com.collabera.board.models;

import java.util.Date;


public class UpdateLog {
	//Primary Key id
	private int id;
	//sudo Foreign key Title
	private String uniqueStringId;
	private String dateOfTheUpdate;

	//TODO Consider class: Content for this to read changes
	private String contentOfTheUpdate;




	public UpdateLog() {
		this.dateOfTheUpdate = new Date().toString();
	}

	public String getNameOfUserThatUpdated() {
		return uniqueStringId;
	}

	public void setNameOfUserThatUpdated(String nameOfUserThatUpdated) {
		this.uniqueStringId = nameOfUserThatUpdated;
	}

	public String getDateOfTheUpdate() {
		return dateOfTheUpdate;
	}

	public void setDateOfTheUpdate(String dateOfTheUpdate) {
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
