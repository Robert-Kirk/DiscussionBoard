package com.collabera.board.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.board.models.Discussion;
import com.collabera.board.services.DiscussionServices;

@RestController
public class DiscussionController {

	@Autowired
	DiscussionServices services;

	// 1. List some
	@GetMapping("/")
	public List<Discussion> listAll() {
		return services.getList();
	}

	// 1.1. Filter list of
	@GetMapping("/{title}")
	public List<Discussion> listFilteredList(@PathVariable(value = "title") String title) {
		return services.getList(title);

	}

	// 1.2. Navigate to specific Discussion

	@GetMapping("/{name}/home")
	public String redirectToSpecificDiscussion(@PathVariable String name) {
		return name;

	}

	// 2. add Discussion
	@PostMapping("/addDiscussion")
	public Discussion addDiscussion(@RequestBody Discussion discussion) {

		return services.addItem(discussion);

	}

	// 3. update Discussion
	@PutMapping("/updateDiscussion/{id}")
	public Discussion updateDiscussion(@PathVariable(value = "id") Long id,
			@RequestBody Discussion discussion) {
		return services.updateItem(id, discussion);

	}

	// 4. delete Discussion
	// SoftDelete
	@PutMapping("/deleteDiscussion/{id}")
	public Discussion deleteDiscussion(@PathVariable(value = "id") Long id) {
		return services.deleteItem(id);

	}

}
