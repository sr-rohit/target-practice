package com.codegym.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Method in a try-catch

*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //write your code here

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();
        Integer number;

        try {

            while(true) {
                number = Integer.parseInt(reader.readLine());
                numbers.add(number);
            }

        } catch (Exception e) {

            for (Integer num : numbers) {
                System.out.println(num);
            }
        }
    }
}
