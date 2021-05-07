package net.kunmc.lab.nicochat.chatflow.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcDateDifference {
    public static Date Calc(Date date1,Date date2){

        long time_difference = date2.getTime() - date1.getTime();
        // Calucalte time difference in days
        long days_difference = (time_difference / (1000*60*60*24)) % 365;
        // Calucalte time difference in years
        long years_difference = (time_difference / (1000l*60*60*24*365));
        // Calucalte time difference in seconds
        long seconds_difference = (time_difference / 1000)% 60;
        // Calucalte time difference in minutes
        long minutes_difference = (time_difference / (1000*60)) % 60;

        // Calucalte time difference in hours
        long hours_difference = (time_difference / (1000*60*60)) % 24;


        return new Date(
                years_difference +
                days_difference +
                seconds_difference +
                minutes_difference +
                hours_difference);
    }
}
