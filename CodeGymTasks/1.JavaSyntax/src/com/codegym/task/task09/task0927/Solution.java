package com.codegym.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Ten cats

*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //write your code here

        HashMap<String, Cat> map = new HashMap<>();
        map.put("A", new Cat("A"));
        map.put("B", new Cat("B"));
        map.put("C", new Cat("C"));
        map.put("D", new Cat("D"));
        map.put("E", new Cat("E"));
        map.put("F", new Cat("F"));
        map.put("G", new Cat("G"));
        map.put("H", new Cat("H"));
        map.put("I", new Cat("I"));
        map.put("J", new Cat("J"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //write your code here
        Set<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> entry : map.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
