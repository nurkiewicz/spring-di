package com.blogspot.nurkiewicz

import org.apache.commons.dbcp.BasicDataSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.jdbc.core.JdbcTemplate
/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:42
 */
object Bootstrap extends App {
	val log: Logger = LoggerFactory.getLogger(classOf[Bootstrap])

	val applicationContext = new AnnotationConfigApplicationContext(classOf[Bootstrap])
	val foo: Foo = applicationContext.getBean(classOf[Foo])
	log.info(foo.serverTime())
	applicationContext.close()
}

@ComponentScan(Array("com.blogspot.nurkiewicz"))
class Bootstrap {

	@Bean def dataSource() = {
		val dataSource: BasicDataSource = new BasicDataSource
		dataSource.setDriverClassName("org.h2.Driver")
		dataSource.setUrl("jdbc:h2:mem:")
		dataSource.setUsername("sa")
		dataSource
	}

	@Bean def jdbcTemplate() = new JdbcTemplate(dataSource())
}