package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = bufferedReader.readLine(),
                    file2 = bufferedReader.readLine(),
                    file3 = bufferedReader.readLine();

            FileReader fileReader2 = new FileReader(file2),
                    fileReader3 = new FileReader(file3);
            FileWriter fileWriter1 = new FileWriter(file1);

            while(fileReader2.ready()) {
                fileWriter1.write(fileReader2.read());
            }
            fileWriter1.flush();

            while(fileReader3.ready()) {
                fileWriter1.write(fileReader3.read());
            }
            fileWriter1.flush();

            fileWriter1.close();
            fileReader2.close();
            fileReader3.close();

        } catch (Exception e) {

        }
    }
}
