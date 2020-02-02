package com.mall.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static long getTimeBetweenByMin(Date start, Date end){
        Calendar startC = Calendar.getInstance();
        startC.setTime(start);
        Calendar endC = Calendar.getInstance();
        endC.setTime(end);
        long minute = 0;
        while(startC.before(endC)){
            startC.add(Calendar.MINUTE,1);
            minute += 1;
        }
        return minute;
    }

    public static long getTimeBetweenByMin2(Date start, Date end){
       long between = end.getTime() -start.getTime();
       long betweenMintue = between/1000/60;
       return betweenMintue;
    }
}
