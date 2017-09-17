package vn.wae.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		String time = "20170221150044";
		Date receiveDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(receiveDate);
		calendar.add(Calendar.HOUR_OF_DAY, 7);
		System.out.println(calendar.getTime());

	}

}
