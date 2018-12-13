package com.yeah.boring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		
		System.out.println("Just to minute: " + strDate);
		System.out.println("Just to minute format to seconds: " + sdDate.format(sdDate.parse(strDate)));
		
		System.out.println("To seconds: " + sdDate.format(now));
		System.out.println("Seconds format to minute: " + sdDate.format(sdDate.parse("2017-08-02 14:35")));
	}
}
