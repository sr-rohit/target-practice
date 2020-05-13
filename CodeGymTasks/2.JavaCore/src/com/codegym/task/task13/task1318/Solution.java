package com.codegym.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

/* 
Reading a file

*/

public class Solution {
    public static void main(String[] args) {
        // write your code here

        BufferedReader reader = null;
        FileInputStream fileInput = null;

        try {

            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            fileInput = new FileInputStream(fileName);

            while(fileInput.available() > 0) {
                char input = (char) fileInput.read();
                System.out.print(input);
            }

            fileInput.close();
            reader.close();

        } catch (IOException e) {

        }
    }
}