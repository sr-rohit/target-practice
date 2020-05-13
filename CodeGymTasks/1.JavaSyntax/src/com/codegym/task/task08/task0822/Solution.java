package com.codegym.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Minimum of N numbers

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Find the minimum here

        int min = Integer.MAX_VALUE;

        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Create and initialize a list here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N, num, i;

        N = Integer.parseInt(reader.readLine());

        List<Integer> list = new ArrayList<>(N);

        for (i = 0; i < N; i++) {
            num = Integer.parseInt(reader.readLine());
            list.add(num);
        }

        return list;
    }
}
