package com.ocjproduction.SocialNetworkingTests;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.ojcproduction.model.JdbcPostDao;
import com.ojcproduction.model.JdbcUserDao;

public class SocialNetworkingTests {
	
	private static SingleConnectionDataSource dataSource;
	private JdbcPostDao postDAO;
	private JdbcUserDao userDAO;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/socialnetworking");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		postDAO = new JdbcPostDao(dataSource);
		userDAO = new JdbcUserDao(dataSource);
		
		// I'm out of time but I would have set up some test users and message posts here...
		
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void test() {
		// out of time...
		
	}

}
