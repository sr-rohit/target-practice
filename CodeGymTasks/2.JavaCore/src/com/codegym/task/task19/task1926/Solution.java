package com.codegym.task.task19.task1926;

/* 
Mirror image

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file = bufferedReader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            while(fileReader.ready()) {

                StringBuilder line = new StringBuilder(fileReader.readLine());
                System.out.println(line.reverse().toString());
            }

            fileReader.close();
            bufferedReader.close();

        } catch (Exception e) {

        }
    }
}
