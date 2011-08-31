package com.blogspot.nurkiewicz;

import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

import static org.apache.commons.lang.time.FastDateFormat.FULL;

/**
 * @author Tomasz Nurkiewicz
 * @since 31.08.11, 21:26
 */
@Service
public class Bar {

	private FastDateFormat dateFormat;

	@PostConstruct
	public void init() {
		dateFormat = FastDateFormat.getDateTimeInstance(FULL, FULL);
	}

	public String format(Date date) {
		return dateFormat.format(date);
	}
}
