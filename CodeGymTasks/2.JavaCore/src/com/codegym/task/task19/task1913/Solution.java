package com.codegym.task.task19.task1913;

/* 
Output only digits

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream original = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream implementation = new PrintStream(outputStream);
        System.setOut(implementation);

        testString.printSomething();
        System.setOut(original);

        String data = outputStream.toString();
        for (char c : data.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.print(c);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This 1 text 23 is 4 f5-6or7 tes8ting");
        }
    }
}
