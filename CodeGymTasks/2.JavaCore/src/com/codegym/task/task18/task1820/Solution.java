package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = bufferedReader.readLine(),
                    file2 = bufferedReader.readLine();

            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(file1));
            BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(file2));
            String line;
            String[] lineParts;
            double number;
            int rounded;

            while (bufferedFileReader.ready()) {

                line = bufferedFileReader.readLine();
                lineParts = line.split(" ");

                for (String part : lineParts) {
                    number = Double.parseDouble(part);
                    rounded = (int) Math.round(number);
                    bufferedFileWriter.write(String.valueOf(rounded) + " ");
                }
            }

            bufferedFileReader.close();
            bufferedFileWriter.close();
            bufferedReader.close();

        } catch (Exception e) {

        }
    }
}
