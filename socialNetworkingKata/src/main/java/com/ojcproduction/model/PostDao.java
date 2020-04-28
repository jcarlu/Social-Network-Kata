package com.ojcproduction.model;

import java.util.List;

public interface PostDao {
	
	public List<Post> getPostsByUsername(String username);
	public void addPost(Post post);

}
