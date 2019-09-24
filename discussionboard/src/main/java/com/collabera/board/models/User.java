package com.collabera.board.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/* User Model */

@Document
public class User {
	//TODO have User implements UserDetails for security
	@Id
	private String Id;
	@Indexed
	private String Username;
	@Indexed
	private String Email;
	private String Password;
	
	public User() {
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}

	public User(String id, String username, String email, String password) {
		super();
		this.Id = id;
		this.Username = username;
		this.Email = email;
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + Id + ", username=" + Username + ", email=" + Email + "password=" + Password + "]";
	}

//	@Override
//	public Collection<GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
}