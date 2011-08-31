package com.blogspot.nurkiewicz;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:42
 */
@ComponentScan("com.blogspot.nurkiewicz")
public class Bootstrap {

	private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

	@Bean
	public DataSource dataSource() {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:");
		dataSource.setUsername("sa");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	public static void main(String[] args) {
		final AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Bootstrap.class);
		final Foo foo = applicationContext.getBean(Foo.class);

		log.info(foo.serverTime());

		applicationContext.close();
	}
}
