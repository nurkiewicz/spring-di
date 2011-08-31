package com.blogspot.nurkiewicz;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:26
 */
@Service
public class Foo {

	@Resource
	private Bar bar;

	@Resource
	private JdbcOperations jdbcOperations;

	public String serverTime() {
		return bar.format(
				jdbcOperations.queryForObject("SELECT now()", Date.class)
		);
	}

}
