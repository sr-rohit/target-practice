package com.codegym.task.task18.task1810;

/* 
DownloadException

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            while (true) {
                FileInputStream fileReader = new FileInputStream(bufferedReader.readLine());
                int bytes = 0;
                while (fileReader.available() > 0) {
                    fileReader.read();
                    bytes++;
                }

                fileReader.close();
                if (bytes < 1000) {
                    throw new DownloadException();
                }
            }

        } catch (IOException exception) {

        }
    }

    public static class DownloadException extends Exception {

    }
}
