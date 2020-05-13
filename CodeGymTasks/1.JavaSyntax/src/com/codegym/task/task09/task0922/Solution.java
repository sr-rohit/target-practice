package com.codegym.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
What's today's date?

*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //write your code here

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("MMM dd, yyyy");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateStr = reader.readLine();

        Date date = df.parse(dateStr);
        System.out.println(df2.format(date).toString().toUpperCase());
    }
}
