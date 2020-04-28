package com.ojcproduction.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcPostDao implements PostDao {
	
	private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public JdbcPostDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
	public List<Post> getPostsByUsername(String username) {
    	
		List<Post> posts = new ArrayList<Post>();
		
		String sql = "SELECT * FROM posts WHERE username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
		while(results.next()) {
			Post post = mapRowToPost(results);
			posts.add(post);
		 }
		return posts;
    	}
    
    @Override
	public void addPost(Post post) {
		String sql = "INSERT INTO posts(post_id, username, message, time_posted) "
				+ " VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, post.getUsername(), post.getPostMessage(),  post.getTimePosted());
	}
    
    private Post mapRowToPost(SqlRowSet results) {
		Post post = new Post();
		post.setPostId(results.getInt("post_id"));
		post.setUsername(results.getString("username"));
		post.setPostMessage(results.getString("message"));
		post.setTimePosted(results.getDate("time_posted").toLocalDate());
		return post;
	}
}
