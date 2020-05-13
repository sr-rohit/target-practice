package com.codegym.task.task15.task1524;

/* 
Order of loading variables

*/

public class Solution {

    static {
        init();
    }

    static {
        System.out.println("Static block");
    }

    public int i;

    public String name;


    public Solution() {
        System.out.println("Solution constructor");
        i = 6;
        name = "First name";
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }
}
