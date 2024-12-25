package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(User user) {
		String query = "insert into public.\"user\"(id, name, age) values(?,?,?);";

		int output = this.jdbcTemplate.update(query, user.getId(), user.getName(), user.getAge());

		return output;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int update(User user) {
		String queryString = "update public.user set name=?, age=? where id=?";

		int r = this.jdbcTemplate.update(queryString, user.getName(), user.getAge(), user.getId());

		return r;
	}

	@Override
	public int deleteUser(int id) {

		String queryString = "DELETE FROM public.user WHERE id=?";

		int r = this.jdbcTemplate.update(queryString, id);

		return r;
	}

	@Override
	public User getUserById(int id) {
		String queryString = "SELECT * from public.user WHERE id = ?";

		User u1 = this.jdbcTemplate.queryForObject(queryString, new RowMapperImpl(), id);

		return u1;
	}

	@Override
	public List<User> getAllUsers() {
		String queryString = "SELECT * FROM public.user";

		List<User> userList = this.jdbcTemplate.query(queryString, new RowMapperImpl());

		return userList;
	}

}
