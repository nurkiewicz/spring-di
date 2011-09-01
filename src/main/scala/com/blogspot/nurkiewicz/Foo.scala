package com.blogspot.nurkiewicz

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import java.util.Date
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:26
 */
@Service
class Foo @Autowired() (bar: Bar, jdbcOperations: JdbcOperations) {

	def serverTime() = bar.format(jdbcOperations.queryForObject("SELECT now()", classOf[Date]))

}