package com.codegym.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Working with dates

*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        Date dated = dateFormat.parse(date);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dated);

        int day = calendar.get(Calendar.DAY_OF_YEAR);
        if (day % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
