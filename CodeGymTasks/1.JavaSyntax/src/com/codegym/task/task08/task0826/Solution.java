package com.codegym.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Five winners

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        //write your code here

        List<Integer> list = new ArrayList<Integer>();
        for (int num : array) {
            list.add(num);
        }

        Collections.sort(list);
        Collections.reverse(list);

        array = new int[array.length];
        int i = 0;
        for (Object num : list) {
            array[i++] = Integer.parseInt(num.toString());
        }
    }
}
