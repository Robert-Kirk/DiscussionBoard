package com.collabera.board.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class DiscussionChannelController {
	
	//1. List some channels
	@GetMapping("/")
	public String listAllChannels() {
		
		return null;
		
	}
	
	
	//1.1. Filter list of channels
	@GetMapping("/{name}")
	public String listFilteredChannelsList(@PathVariable String name) {
		return name;
		
	}
	//1.2. Navigate to specific channel
	@GetMapping("/{name}/home")
	public String redirectToSpecificChannel(@PathVariable String name) {
		return name;
		
	}
	
	//2. add channel
	@GetMapping("/addChannel")
	public String loadAddingChannelPage() {
		
		return null;
		
	}
	@PostMapping("/addChannel")
	public String addChannel() {
		return null;
		
	}
	
	
	//3. delete channel
	@GetMapping("/addChannel")
	public String loadDeleteConfirmation() {
		
		return null;
		
	}
	//SoftDelete
	@PutMapping("/addChannel")
	public String deleteChannel() {
		return null;
		
	}
	
	//4. update channel
	
	@GetMapping("/updateChannel")
	public String loadChannelSettings() {
		
		return null;
		
	}
	//SoftDelete
	@PutMapping("/updateChannel")
	public String updateChannel() {
		return null;
		
	}

}
