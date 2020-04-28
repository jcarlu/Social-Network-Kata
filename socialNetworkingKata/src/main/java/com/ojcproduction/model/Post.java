package com.ojcproduction.model;

import java.time.LocalDate;

public class Post {
	
	private int postId;
	private String username;
	private String postMessage;
	private LocalDate timePosted;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPostMessage() {
		return postMessage;
	}
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}
	public LocalDate getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(LocalDate timePosted) {
		this.timePosted = timePosted;
	}
	
	

}
