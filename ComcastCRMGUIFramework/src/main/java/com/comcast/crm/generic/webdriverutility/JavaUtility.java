package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	{
		Random random = new Random();
		int num=random.nextInt(5000);
		return num;
	}
	
	public String getSystemDateDDMMYYYY()
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dateObj);
		return date;
	}
	
	public String getRequiredDateDDMMYYYY(int days)
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateObj);  
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiredDate=sim.format(cal.getTime());
		return requiredDate;
	}
}
