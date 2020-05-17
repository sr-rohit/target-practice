package com.codegym.task.task20.task2007;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/* 
How do you serialize CodeGym?

*/
public class Solution {
    public static class CodeGym implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {

        CodeGym codeGym = new CodeGym();
        System.out.println(codeGym);
    }
}
