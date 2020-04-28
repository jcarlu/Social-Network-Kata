package com.ojcproduction.model;

import java.util.List;
import org.hibernate.validator.constraints.NotBlank;


public class User {
	
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Password is required")
    private String password;

    private List<User> iFollow;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getiFollow() {
		return iFollow;
	}

	public void setiFollow(List<User> iFollow) {
		this.iFollow = iFollow;
	}
   
    
    
}