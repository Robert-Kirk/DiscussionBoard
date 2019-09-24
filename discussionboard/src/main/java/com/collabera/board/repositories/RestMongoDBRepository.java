package com.collabera.board.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collabera.board.models.User;

// spring data framework provides default implementations for all the crud operations

@Repository
public interface RestMongoDBRepository extends MongoRepository<User, String> {

	// CRUD operations on MongoDB
	// save
	// find
	// delete
	// update - save
	
	// read 
	public List<User> listUsernames(String username);
	
	// get
	public User getUsername(String id);
	
	// create
	public User addUsername(String username, String email, String password);
	
	// delete
	public User deleteUsername(String userId);
	
	// update
	public User updateUsername(User user);
}