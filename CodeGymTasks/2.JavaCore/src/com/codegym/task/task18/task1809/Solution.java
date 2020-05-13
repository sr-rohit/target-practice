package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/

import java.io.*;

public class Solution {

    private static void reverseFile(FileInputStream reader, FileOutputStream writer) throws Exception {

        int code = reader.read();
        if (reader.available() > 0) {
            reverseFile(reader, writer);
        }
        writer.write(code);
    }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1, file2;

        try {

            file1 = reader.readLine();
            file2 = reader.readLine();

            FileInputStream fileReader = new FileInputStream(file1);
            FileOutputStream fileWriter = new FileOutputStream(file2);

            if (fileReader.available() > 0) {
                reverseFile(fileReader, fileWriter);
            }

            fileReader.close();
            fileWriter.close();

        } catch(Exception e) {
        }
    }
}
