package com.collabera.board.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.board.models.User;
import com.collabera.board.repositories.RestMongoDBRepository;

@Service
public class UserServiceMDB {

	@Autowired
	RestMongoDBRepository restMongoDBRepository; // interface which is autowired
	
	// read admin
	public List<User> listUsernames(String username) {
		return restMongoDBRepository.findAll();
	}
	
	public User getUsername(String id){
        //UserDAO getUser and return the user
		return restMongoDBRepository.findById(id).get();
	}
	
	// create
	public User addUsername(String username, String email, String password) {
		
		User newUser = new User(null, username, email, password);
		
		return restMongoDBRepository.save(newUser);
	}
	
	// delete
	public User deleteUsername(String id) {
		//UserDAL deleteUser in DB and return the object deleted
		Optional<User> deleteUsername = restMongoDBRepository.findById(id);
		
		restMongoDBRepository.deleteById(id);
		return deleteUsername.get();
	}

	public User updateUsername(User user) {
		//UserDAO updateUser in DB and return the object 
		return restMongoDBRepository.save(user);
	}
}