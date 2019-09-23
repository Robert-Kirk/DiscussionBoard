package com.collabera.board.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.board.models.DiscussionChannel;
import com.collabera.board.services.DiscussionChannelServices;

@RestController
public class DiscussionChannelController {

	@Autowired
	DiscussionChannelServices services;

	// 1. List some channels
	@GetMapping("/")
	public List<DiscussionChannel> listAllChannels() {
		return services.getList();
	}

	// 1.1. Filter list of channels
	@GetMapping("/{title}")
	public List<DiscussionChannel> listFilteredChannelsList(@PathVariable(value = "title") String title) {
		return services.getList(title);

	}

	// 1.2. Navigate to specific channel

	@GetMapping("/{name}/home")
	public String redirectToSpecificChannel(@PathVariable String name) {
		return name;

	}

	// 2. add channel
	@PostMapping("/addChannel")
	public DiscussionChannel addChannel(@RequestBody DiscussionChannel channel) {

		return services.addItem(channel);

	}

	// 3. update channel
	@PutMapping("/updateChannel/{id}")
	public DiscussionChannel updateChannel(@PathVariable(value = "id") String id,
			@RequestBody DiscussionChannel channel) {
		return services.updateItem(id, channel);

	}

	// 4. delete channel
	// SoftDelete
	@PutMapping("/deleteChannel/{id}")
	public DiscussionChannel deleteChannel(@PathVariable(value = "id") String id) {
		return services.deleteItem(id);

	}

}
