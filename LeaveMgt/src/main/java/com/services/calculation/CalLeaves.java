package com.services.calculation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalLeaves 
{
	static String from;
	static String to;
	static SimpleDateFormat myFormat;
	static SimpleDateFormat year;
	static double countplanedleaves;
	static ArrayList<Date> weekends;
	static ArrayList<Date> listofTotalweekends;
	int exactyear = 0;
	static int totalHolidays = 0;
	static int satsundays;
	public static String weekkend;

	private static Calendar cal = null;
	private static int year1;
	private static int year2;

	public static ArrayList<Date> weekendList = null;
	public static ArrayList<Date> HolidayList = null;
	public static ArrayList<Date> weekendList2 = null;



	public  int LeavedaysCounter(String datefrom, String dateupto) {

		myFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			weekends = WeekendsCount(datefrom, dateupto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Date d : weekends) {
			System.out.println(myFormat.format(d));
		}
		int count = weekends.size();
		System.out.println(count);

		return count;
	}

	
	//To get Weekends between given Dates
	public  ArrayList<Date> WeekendsCount(String from, String to) throws ParseException {
		
		
		ArrayList<Date> dates = new ArrayList<Date>();
		
		

		Date startDate = myFormat.parse(from);
		Date endDate = myFormat.parse(to);

		long interval = 24 * 1000 * 60 * 60; // 1 hour in milliseconds
		long endTime = endDate.getTime(); // creating endtime 
											
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
			dates.add(new Date(curTime));
			curTime += interval;
		}
		
		satsundays = 0;
		listofTotalweekends = weekdays(from, to);
		for (Date date : listofTotalweekends) {

			for (Date hi : dates) {
				if (date.equals(hi)) {
					weekkend = myFormat.format(hi);
					satsundays++;

				}
			}
		}
		HolidayList=publicHolidayCheck();// Getting list of Holidays
		dates.removeAll(listofTotalweekends);//  removing Saturdays and Sundays From given start date and End date
		dates.removeAll(HolidayList);// removing Holidays From given start date and End date
		
		return dates;
	}public ArrayList<Date> publicHolidayCheck() throws ParseException
	{
		String publicHolidays[] ={"01/01/2016","26/01/2016","24/03/2016","15/08/2016","15/09/2016","11/10/2016","31/10/2016","01/11/2016"};//Array of Public Holidays
		myFormat =new SimpleDateFormat("dd/MM/yyyy");
		
		Date publicHoliday[] = new Date[publicHolidays.length];//Array Of Dates
		int totalHolidays = 0;//To take count of Holidays coming between Start date and end date
		ArrayList<Date> publicHolidayList = new ArrayList<Date>();
		for (int i = 0; i < publicHolidays.length; i++)
		{
			publicHoliday[i]=myFormat.parse(publicHolidays[i]);//converting string array into Date array
			publicHolidayList.add(publicHoliday[i]);//adding Into ArrayList
			totalHolidays++;

		}
		return publicHolidayList;
	}

//To get WeekendList From given Start and end Dates
	public  ArrayList<Date> weekdays(String from, String to) {
		weekendList = new ArrayList<Date>(53);
		Date yearpattern1 = null;
		Date yearpattern2 = null;
		try {
			year1 = getYear(from);
			year2 = getYear(to);
			yearpattern1 = myFormat.parse(from);
			yearpattern2 = myFormat.parse(to);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (year1 == year2) 
		{
			cal = Calendar.getInstance();
			cal.setTime(yearpattern1);//setting time for given date
			weekendList = findWeekends(year1);// finding Weekends for given year
			return weekendList;
		} 
		else 
		{
			cal = Calendar.getInstance();
			cal.setTime(yearpattern1);//setting time for given date
			weekendList = findWeekends(year1);// finding Weekends for given year
			cal.setTime(yearpattern2);////setting time for given date
			weekendList = findWeekends(year2);// finding Weekends for given year
			return weekendList;
		}
}
//To get Only Year from given Date 
	public  int getYear(String d) throws ParseException {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = myFormat.parse(d); //parsing a string into Date in a given format
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date); // setting time as given date
		exactyear=calendar.get(Calendar.YEAR);//getting onll year of that particular date
		return exactyear;
	}

	public  ArrayList<Date> findWeekends(int year1) {
		Date dd = null;
		try {
			dd = myFormat.parse("01/01/" + year1);//parsing string into Date
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Calendar calend = Calendar.getInstance();
		calend.setTime(dd);// Setting Time as 1st day of 1st month  of That particular year
	
	// The while loop ensures that you are only checking dates in the specified year
		while (calend.get(Calendar.YEAR) == year1) {
	// The switch checks the day of the week for Saturdays and Sundays
			switch (calend.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SATURDAY:
			case Calendar.SUNDAY:
				weekendList.add(calend.getTime());// returns true or false
				break;
			}
// Increment the day of the year for the next iteration of the while loop
			calend.add(Calendar.DAY_OF_YEAR, 1);
		}
		return weekendList;

	}


}
