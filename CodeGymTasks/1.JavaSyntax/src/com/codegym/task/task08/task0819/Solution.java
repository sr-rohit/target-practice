package com.codegym.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set of cats

*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Object[] catsArray = cats.toArray();

        //write your code here. step 3
        cats.remove(catsArray[0]);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //write your code here. step 2
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat("A"));
        cats.add(new Cat("B"));
        cats.add(new Cat("C"));
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4

        for (Cat cat : cats) {
            System.out.println(cat.name);
        }
    }

    // step 1

    public static class Cat {

        private String name;

        public Cat() {
            this.name = "XXX";
        }

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println(obj);
            return this.name.equals(((Cat) obj).name);
        }
    }
}
