package com.codegym.task.task09.task0906;

/* 
Logging stack traces

*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //write your code here

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement stackElement = stack[2];
        System.out.println(stackElement.getClassName() + ": " + stackElement.getMethodName() + ": " + s);
    }
}
