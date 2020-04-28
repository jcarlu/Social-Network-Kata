package com.ojcproduction.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

   
    @Autowired
    public JdbcUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
	public void newUser(User user) {
		String sql = "INSERT INTO users(username, firstname, password) VALUES(?,?,?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getFirstName(), user.getPassword());
		
	}
    
	@Override
	public List<String> getPeopleIFollow(String username) {
		List <String> usersIFollow = new ArrayList <> ();
		String sqlPeopleIFollow = "SELECT follows_user FROM followers WHERE username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlPeopleIFollow, username);
			while(results.next()) {
				usersIFollow.add(results.getString("username"));
			}
			return usersIFollow;	
	} 
	
	@Override
	public void followUser(String username, String followUser) {
		String sqlFollowUser = "INSERT INTO followers (username, follows_user) VALUES(?,?)";
		jdbcTemplate.update(sqlFollowUser, username, followUser);
	}
	
	

}
