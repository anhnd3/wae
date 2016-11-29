package vn.wae.spring.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	public static String timestampToString(long timestamp, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String strDate = dateFormat.format(new Date(timestamp));
		return strDate;
	}
}
