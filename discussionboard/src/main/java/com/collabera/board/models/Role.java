package com.collabera.board.models;

public class Role {
	
	private String roleName;
	private String authroitiesGranted;
	
	private UpdateTracker updateTracker;

	public Role() {
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAuthroitiesGranted() {
		return authroitiesGranted;
	}

	public void setAuthroitiesGranted(String authroitiesGranted) {
		this.authroitiesGranted = authroitiesGranted;
	}

	public UpdateTracker getUpdateTracker() {
		return updateTracker;
	}

	public void setUpdateTracker(UpdateTracker updateTracker) {
		this.updateTracker = updateTracker;
	}
	
	
	

}
