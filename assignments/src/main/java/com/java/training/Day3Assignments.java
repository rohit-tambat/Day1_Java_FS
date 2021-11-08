package com.java.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Day3Assignments {

	public static void main(String args[]) throws Exception {
		convertString2Date("May 1, 2016");// Program1
		displayDateTime("2016-07-14 09:00:02");// Program2
		displayDayOfYear("2013-03-23");// Program3
		getDayOfWeek("2011-07-11");// Program4
		diffInMonthOfGivenDate("2012-03-01", "2012-04-16");//// Program5
	}

	// Program1//Date time formatter can be used to convert String to
	// date//1.Display Date
	public static void convertString2Date(String strDate) throws ParseException {
		System.out.println(LocalDate.parse(strDate, DateTimeFormatter.ofPattern("MMM d, yyyy")));
	}

	// Program2//2.Extract Date and time
	public static void displayDateTime(String strDate) throws ParseException {
		// yyyy-MM-dd HH:mm:ss
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
		String strFormatedDate = new SimpleDateFormat("MM/dd/yyyy, H:mm:ss").format(date);
		System.out.println(strFormatedDate);
	}

	// Program 3//3.Day Of The Year
	public static void displayDayOfYear(String strDate) throws ParseException {
		Date md = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		Calendar c = Calendar.getInstance();
		c.setTime(md);
		System.out.println(c.get(Calendar.DAY_OF_YEAR));

	}

	// Program 4
	public static void getDayOfWeek(String date) throws ParseException {
		Date md = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(md);
		LocalDate localDate = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
		java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		System.out.println(dayOfWeek.toString());
	}

	// Program5
	public static void diffInMonthOfGivenDate(String date1, String date2) throws ParseException {
		Date md1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Calendar c1 = Calendar.getInstance();
		c1.setTime(md1);
		Date md2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(md2);
		int monthDiff = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		System.out.println(monthDiff);
	}

}
