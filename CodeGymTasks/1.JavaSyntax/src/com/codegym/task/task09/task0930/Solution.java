package com.codegym.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Task about algorithms

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s == null || s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // write your code here

        int len = array.length, i, j, k;
        String str;

        for (i = 0; i < (len - 1); i++) {
            for (j = 0; j < (len - i - 1); j++) {
                for (k = j + 1; k < (len - i); k++) {
                    if (isNumber(array[j]) && isNumber(array[k])) {
                        if (Integer.parseInt(array[j]) < Integer.parseInt(array[k])) {
                            str = array[j];
                            array[j] = array[k];
                            array[k] = str;
                            break;
                        }
                    } else if (!isNumber(array[j]) && !isNumber(array[k])) {
                        if (isGreaterThan(array[j], array[k])) {
                            str = array[j];
                            array[j] = array[k];
                            array[k] = str;
                            break;
                        }
                    }
                }
            }
        }

    }

    // String comparison method: 'a' is greater than 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Is the passed string a number?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // The string contains a hyphen
                    || (!Character.isDigit(c) && c != '-') // or is not a number and doesn't start with a hyphen
                    || (i == 0 && c == '-' && chars.length == 1)) // or is a single hyphen
            {
                return false;
            }
        }
        return true;
    }
}
