package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = bufferedReader.readLine(),
                    file2 = bufferedReader.readLine();

            List<String> fileContents = new ArrayList<>();
            BufferedReader fileReader1 = new BufferedReader(new FileReader(file1)),
                    fileReader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter fileWriter1 = new BufferedWriter(new FileWriter(file1));

            while (fileReader2.ready()) {
                fileContents.add(fileReader2.readLine());
            }

            while (fileReader1.ready()) {
                fileContents.add(fileReader1.readLine());
            }

            for (String line : fileContents) {
                fileWriter1.write(line);
            }
            fileWriter1.flush();

            fileReader1.close();
            fileReader2.close();
            fileWriter1.close();
            bufferedReader.close();

        } catch (Exception e) {

        }
    }
}
