package com.collabera.board.models;

import java.util.List;

public class CommentTrees {
	

	
	private List<UserComment> comments;
	 
	 private UpdateTracker updateTraker;

	public CommentTrees() {}



	public UpdateTracker getUpdateTraker() {
		return updateTraker;
	}

	public void setUpdateTraker(UpdateTracker updateTraker) {
		this.updateTraker = updateTraker;
	}

	public List<UserComment> getComments() {
		return comments;
	}

	public void setComments(List<UserComment> comments) {
		this.comments = comments;
	} 

	
	//For use if we use a TreeSet instead of nested lists for our comment tree
	
//	 private SortedSet<UserComment> s; //= new TreeSet<UserComment>();
	
//	public SortedSet<UserComment> getS() {
//	return s;
//}
//
//public void setS(SortedSet<UserComment> s) {
//	this.s = s;
//}
}
