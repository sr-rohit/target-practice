package com.codegym.task.task19.task1906;

/* 
Even characters

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String file1, file2;

        try {

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            file1 = consoleReader.readLine();
            file2 = consoleReader.readLine();

            consoleReader.close();

            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);
            int index = 1, character;

            while (fileReader.ready()) {
                character = fileReader.read();
                if (index % 2 == 0) {
                    fileWriter.write(character);
                }
                index++;
            }

            fileReader.close();
            fileWriter.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
