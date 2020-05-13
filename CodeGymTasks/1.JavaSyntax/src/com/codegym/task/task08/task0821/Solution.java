package com.codegym.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Shared last names and first names

*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //write your code here

        HashMap<String, String> people = new HashMap<>();
        people.put("A", "A");
        people.put("B", "D");
        people.put("C", "C");
        people.put("D", "D");
        people.put("E", "A");
        people.put("F", "F");
        people.put("G", "G");
        people.put("H", "H");
        people.put("I", "I");
        people.put("E", "J");

        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
