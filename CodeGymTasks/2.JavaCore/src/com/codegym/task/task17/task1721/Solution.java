package com.codegym.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) {

        String file1, file2;

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));

            while (bufferedReader1.ready()) {
                allLines.add(bufferedReader1.readLine());
            }

            while(bufferedReader2.ready()) {
                linesForRemoval.add(bufferedReader2.readLine());
            }

            bufferedReader1.close();
            bufferedReader2.close();

            Solution solution = new Solution();
            solution.joinData();

        } catch (IOException e) {

        }
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.size() < linesForRemoval.size()) {
            allLines.clear();
            throw new CorruptedDataException();
        }

        for (String line : linesForRemoval) {
            if (allLines.contains(line)) {
                allLines.remove(line);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
