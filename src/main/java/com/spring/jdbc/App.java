package com.spring.jdbc;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.UserDaoImpl;
import com.spring.jdbc.entities.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Program started......");

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/mysqlConfig.xml");

		UserDaoImpl userDao = context.getBean("userDao", UserDaoImpl.class);

		User u1 = new User();

		u1.setId(3);
		u1.setName("Lucky123");
		u1.setAge(33);

//		int result = userDao.create(u1);

//		System.out.println("Total rows effected : " + result);

		List<User> userList = userDao.getAllUsers();

		for (User user : userList) {
			System.out.println(user);
		}

		context.close();
	}
}
