package com.collabera.board.models;

@Deprecated
public class Role {

	private String roleName;
	private String authroitiesGranted;

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

}
