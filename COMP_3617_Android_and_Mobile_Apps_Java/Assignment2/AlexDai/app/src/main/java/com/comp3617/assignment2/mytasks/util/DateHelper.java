package com.comp3617.assignment2.mytasks.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {

    public static Calendar convertToCalendar(String str) {
        // format: yyyy-MM-dd
        int year = Integer.valueOf(str.substring(0, 4));
        int monthOfYear = Integer.valueOf(str.substring(5,7)) - 1;
        int dayOfMonth = Integer.valueOf(str.substring(8));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        return calendar;
    }

    public static String getDateString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(calendar.getTime());
        return formattedDate;
    }



}
