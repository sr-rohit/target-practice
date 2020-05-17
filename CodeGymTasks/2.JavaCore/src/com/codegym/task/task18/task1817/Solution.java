package com.codegym.task.task18.task1817;

/* 
Spaces

*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {

        try {

            String file = args[0];
            FileInputStream fileInputStream = new FileInputStream(file);
            int chars = 0, spaces = 0;
            char character;

            while (fileInputStream.available() > 0) {
                character = (char) fileInputStream.read();
                if (Character.isSpaceChar(character)) {
                    spaces++;
                }
                chars++;
            }
            System.out.printf("%.2f", ((spaces * 100.0) / chars));

            fileInputStream.close();

        } catch (Exception e) {

        }
    }
}
