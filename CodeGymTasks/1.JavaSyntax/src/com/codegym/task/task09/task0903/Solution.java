package com.codegym.task.task09.task0903;

/* 
Who called me?

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static int method1() {
        method2();
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int lineNumber = stack[0].getLineNumber();

        return  /*write your code here*/ lineNumber;
    }

    public static int method2() {
        method3();
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int lineNumber = stack[0].getLineNumber();

        return  /*write your code here*/ lineNumber;
    }

    public static int method3() {
        method4();
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int lineNumber = stack[0].getLineNumber();

        return  /*write your code here*/ lineNumber;
    }

    public static int method4() {
        method5();
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int lineNumber = stack[0].getLineNumber();

        return  /*write your code here*/ lineNumber;
    }

    public static int method5() {

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int lineNumber = stack[0].getLineNumber();

        return  /*write your code here*/ lineNumber;
    }
}
