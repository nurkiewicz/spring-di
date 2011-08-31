package com.blogspot.nurkiewicz

import org.apache.commons.lang.time.FastDateFormat
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import java.util.Date
import org.apache.commons.lang.time.FastDateFormat.FULL

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:26
 */
@Service
class Bar {
	private var dateFormat: FastDateFormat = null

	@PostConstruct def init() {
		dateFormat = FastDateFormat.getDateTimeInstance(FULL, FULL)
	}

	def format(date: Date): String = dateFormat.format(date)

}