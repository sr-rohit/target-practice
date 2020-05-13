package com.codegym.task.task19.task1925;

/* 
Long words

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        try {

            String file1 = args[0],
                    file2 = args[1];

            String line;
            List<String> words = new ArrayList<>();

            BufferedReader fileReader = new BufferedReader(new FileReader(file1));
            FileWriter fileWriter = new FileWriter(file2);
            while(fileReader.ready()) {

                line = fileReader.readLine();
                for(String word : line.split(" ")) {
                    if (word.length() > 6) {
                        words.add(word);
                    }
                }
            }
            fileReader.close();

            fileWriter.write(String.join(",", words));
            fileWriter.close();

        } catch (Exception e) {

        }
    }
}
