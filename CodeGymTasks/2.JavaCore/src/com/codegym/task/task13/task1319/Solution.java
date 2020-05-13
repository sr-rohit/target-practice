package com.codegym.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Writing to a file from the console

*/

public class Solution {
    public static void main(String[] args) {
        // write your code here
        
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            
            String input;
            do {
                
                input = reader.readLine();
                writer.write(input);
                writer.newLine();
                
            } while (!input.equals("exit"));
            
            writer.flush();
            writer.close();
            reader.close();
            
            
        } catch (IOException e) {
            
        }
    }
}
