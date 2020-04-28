package com.ojcproduction.model;

import java.util.List;

public interface UserDao {

  	public void newUser(User user);
  	public List<String> getPeopleIFollow(String username);
  	public void followUser(String username, String followUser);

}
