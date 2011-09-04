package com.blogspot.nurkiewicz;

import org.springframework.jdbc.core.JdbcOperations;

import java.util.Date;

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:26
 */
public class Foo {

	private Bar bar;

	private JdbcOperations jdbcOperations;

	public String serverTime() {
		return bar.format(
				(Date)jdbcOperations.queryForObject("SELECT now()", Date.class)
		);
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public void setJdbcOperations(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
}
