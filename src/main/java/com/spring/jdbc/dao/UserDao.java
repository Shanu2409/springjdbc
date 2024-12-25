package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.User;

public interface UserDao {
	public int create(User user);

	public int update(User user);

	public int deleteUser(int id);

	public User getUserById(int id);

	public List<User> getAllUsers();
}
