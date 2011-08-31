package com.blogspot.nurkiewicz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:42
 */
public class Bootstrap {

	private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

	public static void main(String[] args) {
		final AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		final Foo foo = applicationContext.getBean(Foo.class);

		log.info(foo.serverTime());

		applicationContext.close();
	}
}
