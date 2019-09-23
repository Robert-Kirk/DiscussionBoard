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
import com.collabera.board.models.DiscussionChannel;
import com.collabera.board.services.DiscussionServices;

@RestController
public class DiscussionController {

	@Autowired
	DiscussionServices services;

	// 1. List some 
	@GetMapping("{channelId}")
	public List<Discussion> listAll(@PathVariable(value = "channelId") String channelId) {
		return services.getList(channelId);
	}

	// 1.1. Filter list of 
	@GetMapping("/{title}")
	public List<Discussion> listFilteredList(@PathVariable(value = "title") String title) {
		return services.serachForDiscussion(title);

	}

	// 1.2. Navigate to specific Discussion

	@GetMapping("/{name}/home")
	public String redirectToSpecificDiscussion(@PathVariable String name) {
		return name;

	}

	// 2. add Discussion
	@PostMapping("{channelId}/addDiscussion")
	public DiscussionChannel addDiscussion(@RequestBody Discussion discussion, @PathVariable(value = "channelId") String channelId) {

		return services.addItem(channelId, discussion);

	}

	// 3. update Discussion
	@PutMapping("{channelId}/updateDiscussion/{id}")
	public Discussion updateDiscussion(@PathVariable(value = "channelId") String channelId, @PathVariable(value = "id") String id, 
			@RequestBody Discussion discussion) {
		return services.updateItem(channelId, id, discussion);

	}

	// 4. delete Discussion
	// SoftDelete
	@PutMapping("{channelId}/deleteDiscussion/{id}")
	public Discussion deleteDiscussion(@PathVariable(value = "channelId") String channelId, @PathVariable(value = "id") String id) {
		return services.deleteItem(channelId, id);

	}

}
