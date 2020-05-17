package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {

        try {
            String file = args[0];
            FileInputStream fileInputStream = new FileInputStream(file);
            char character;
            int count = 0;

            while (fileInputStream.available() > 0) {

                character = (char) fileInputStream.read();
                if ((character >= 'A'&& character <= 'Z') || (character >= 'a' && character <= 'z')) {
                    count++;
                }
            }

            System.out.println(count);
            fileInputStream.close();

        } catch (Exception e) {

        }
    }
}
