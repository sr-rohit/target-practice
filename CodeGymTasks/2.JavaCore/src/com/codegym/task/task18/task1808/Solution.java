package com.codegym.task.task18.task1808;

/* 
Splitting a file

*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = bufferedReader.readLine(),
                    file2 = bufferedReader.readLine(),
                    file3 = bufferedReader.readLine();

            FileInputStream fileInputStream1 = new FileInputStream(file1);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2),
                    fileOutputStream3 = new FileOutputStream(file3);

            int length = fileInputStream1.available();
            int mid = (length % 2 == 0) ? (length / 2) : ((length / 2) + 1);
            int count = 0;

            while(fileInputStream1.available() > 0 && count < mid) {
                fileOutputStream2.write(fileInputStream1.read());
                count++;
            }

            while(fileInputStream1.available() > 0) {
                fileOutputStream3.write(fileInputStream1.read());
            }

            fileInputStream1.close();
            fileOutputStream2.close();
            fileOutputStream3.close();

        } catch (IOException e) {

        }
    }
}
