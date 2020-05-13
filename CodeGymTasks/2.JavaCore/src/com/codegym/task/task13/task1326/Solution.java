package com.codegym.task.task13.task1326;

/* 
Sorting even numbers from a file

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //write your code here

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String fileLine;
            List<Integer> list = new ArrayList<>();
            int num;

            do {

                fileLine = fileReader.readLine();
                if (fileLine != null && !fileLine.isEmpty()) {
                    num = Integer.parseInt(fileLine);
                    if (num % 2 == 0) {
                        list.add(num);
                    }
                }

            } while (fileLine != null && !fileLine.isEmpty());

//            for (int number : list) {
//                System.out.println(number);
//            }

            Collections.sort(list);

            for (int number : list) {
                System.out.println(number);
            }

            fileInputStream.close();
            fileReader.close();
            reader.close();

        } catch (IOException e) {

        }
    }
}
