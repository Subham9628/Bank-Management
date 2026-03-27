package com.bank.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTime 
{
	private String date;
	private String time;
	public DateAndTime()
	{
		LocalDate date1=LocalDate.now();
		LocalTime time1=LocalTime.now();
		String arr[]=date1.toString().split("-");
		StringBuilder builder=new StringBuilder();
		builder.append(arr[0]+"-");
		builder.append(arr[1]+"-");
		builder.append(arr[2]);
		date=builder.toString();
		time=time1.toString().substring(0,5);
	}
	public String  getDate()
	{
		return date;
	}
	public String getTime()
	{
		return time;
	}
}
