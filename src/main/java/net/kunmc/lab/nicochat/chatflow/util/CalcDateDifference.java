package net.kunmc.lab.nicochat.chatflow.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcDateDifference {
    public static long Calc(Date date1,Date date2){

        if(date1.after(date2)){
            return date1.getTime()- date2.getTime();
        }else {
            return date2.getTime()- date1.getTime();
        }
    }
}
