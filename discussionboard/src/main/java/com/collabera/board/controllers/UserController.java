package com.collabera.board.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
//import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.board.models.User;
import com.collabera.board.services.UserServiceMDB;


@RestController
public class UserController {

	//list users
	@Autowired
	UserServiceMDB userServiceMDB; // = new userServiceMDB;
	
	// Read - Get all user's for a given user
	
	@GetMapping("/users/{username}/users")
	public ResponseEntity<?> getUserList(@PathVariable String username) {
		
		List<User> listUsers = null;
		
		listUsers = userServiceMDB.listUsernames(username);

		if(listUsers.isEmpty()) {
			return ResponseEntity.noContent().build(); //no content
		}
		return ResponseEntity.ok(listUsers);
			
	}

	// V1
	// get a user of a given user

	// /users/vijay/users/1
	
	@GetMapping("/users/{username}/users/{id}") // Get -> http://localhost:8080/users/vijay/users
	public Resource<ResponseEntity<User>> getUserById(@PathVariable String username, @PathVariable String id) {
		

		
		User user = userServiceMDB.getUsername(id);
				
		if(user == null) {
			return new Resource<ResponseEntity<User>>(ResponseEntity.notFound().build());
		}
		
		Resource<ResponseEntity<User>> userResource = new Resource<ResponseEntity<User>>(new ResponseEntity<User>(user, HttpStatus.OK));
		
		ControllerLinkBuilder selfLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder
				.methodOn(UserController.class)
				.getUserById(username, user.getId() + "")
				);
		
		
		
		ControllerLinkBuilder deleteLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder
				.methodOn(UserController.class)
				.deleteUserById(username, user.getId() + "")
				);
		
		ControllerLinkBuilder editLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder
				.methodOn(UserController.class)
				.updateUserToUser(username, user)
				);

		userResource.add(selfLink.withSelfRel());
		userResource.add(deleteLink.withRel("Delete"));
		userResource.add(editLink.withRel("Edit"));
		
		return userResource;
	}
	
	// V2
	
	// Add - create
	@PostMapping("/users/{username}/users")
	public ResponseEntity<User> addUserToUser(@PathVariable String username, @RequestBody User user) {
		
		//Alter http response data - status code, headers body
		if(username.equals("vijay")) {
			return ResponseEntity.noContent().build();
		}
		
		User newUser = userServiceMDB.addUsername(username, user.getEmail(), user.getPassword());
		// status 201 created as a message
		
		// http://localhost:8080/users/vijay/users/10
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	// Update
	@PutMapping("/users/{username}/users")
	public ResponseEntity<User> updateUserToUser(@PathVariable String username, @RequestBody User user) {
		User updateduser = userServiceMDB.updateUsername(user);
		
		if(updateduser == null) {
			return ResponseEntity.notFound().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateduser.getId()).toUri();
		
		return ResponseEntity.accepted().header("Location", location.toString()).build();
	}

	// Delete
	@DeleteMapping("/users/{username}/users/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable String username, @PathVariable String id) {
		
		User deleteUser = userServiceMDB.deleteUsername(id);
		
		if(deleteUser == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(deleteUser);
	}
}