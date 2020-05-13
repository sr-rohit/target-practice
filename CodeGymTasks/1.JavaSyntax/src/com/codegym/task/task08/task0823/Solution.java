package com.codegym.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* 
Going national

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //write your code here
        String[] strArr = s.split(" ");
        String[] strArr2 = new String[strArr.length];
        int i = 0;

        for (String str : strArr) {
            strArr2[i] = str.substring(0, 0).toUpperCase() + str.substring(1);
            i++;
        }

        List<String> strList = Arrays.asList(strArr2);
        s = String.join(" ", strList);
        System.out.println(s);
    }
}
