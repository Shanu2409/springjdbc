package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configurable
@ComponentScan(basePackages = { "com.spring.jdbc.dao" })
public class JavaConfig {

	@Bean("ds")
	public DriverManagerDataSource getDeriverDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/demo");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean("mySqlJdbcTemp")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDeriverDataSource());
		return jdbcTemplate;
	}
}
