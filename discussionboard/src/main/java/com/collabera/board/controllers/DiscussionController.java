package com.collabera.board.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.board.models.Discussion;
import com.collabera.board.services.DiscussionServices;

import io.swagger.annotations.Api;

@RestController
@Api(value="Discussion Controller")
@RequestMapping("/channels/{channelId}")
public class DiscussionController {

	@Autowired
	DiscussionServices services;

	// 1. List some 
	@GetMapping("/")
	public List<Discussion> listAll(@PathVariable(value = "channelId") String channelId) {
		return services.getList(channelId);
	}

	// 1.1. Filter list of 
	@GetMapping("/{title}")
	public List<Discussion> listFilteredList(@PathVariable(value = "title") String title) {
		return services.serachForDiscussion(title);

	}

	// 2. add Discussion
	@PostMapping("/")
	public Discussion addDiscussion(@RequestBody Discussion discussion, @PathVariable(value = "channelId") String channelId) {

		return services.addItem(channelId, discussion);

	}

	// 3. update Discussion
	@PutMapping("/{id}")
	public Discussion updateDiscussion(@PathVariable(value = "channelId") String channelId, @PathVariable(value = "id") String id, 
			@RequestBody Discussion discussion) {
		return services.updateItem(channelId, id, discussion);

	}

	// 4. delete Discussion
	// SoftDelete
	@DeleteMapping("/{id}")
	public Discussion deleteDiscussion(@PathVariable(value = "channelId") String channelId, @PathVariable(value = "id") String id) {
		return services.deleteItem(channelId, id);

	}

}
