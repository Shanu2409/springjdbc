package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.User;

public class RowMapperImpl implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User newUser = new User();

		newUser.setId(rs.getInt(1));
		newUser.setAge(rs.getInt(2));
		newUser.setName(rs.getString(3));

		return newUser;
	}

}
