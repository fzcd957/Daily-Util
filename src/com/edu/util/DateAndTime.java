package com.edu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
//日期转换
public class DateAndTime {
	public static String currentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date date = new Date(System.currentTimeMillis());
		
		return sdf.format(date);
	}
}
