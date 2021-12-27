package com.spring.security.utils;

import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat {

	private static final String Max = Long.toString(Long.MAX_VALUE);
	public Date covertToDate(String a) throws ParseException {

		SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		formatter6.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
		Date date = formatter6.parse(a);
		return date;
	}

	public String now() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formatDateTime = now.format(formatter);
		System.out.println(formatDateTime);
		return formatDateTime;

	}
	
//	public Date convertDate(Date date) throws ParseException {
//		String date2 =  date.replace(" UTC", "");
//		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date2);
//	}

}
