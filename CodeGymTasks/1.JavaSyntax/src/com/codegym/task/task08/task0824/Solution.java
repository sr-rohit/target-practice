package com.codegym.task.task08.task0824;

/* 
Make a family

*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //write your code here

        Human child1 = new Human();
        child1.name = "A";
        child1.sex = true;
        child1.age = 10;
        child1.children = new ArrayList<>();

        Human child2 = new Human();
        child2.name = "B";
        child2.sex = false;
        child2.age = 5;
        child2.children = new ArrayList<>();

        Human child3 = new Human();
        child3.name = "C";
        child3.sex = true;
        child3.age = 2;
        child3.children = new ArrayList<>();

        Human father = new Human();
        father.name = "D";
        father.sex = true;
        father.age = 40;
        father.children = new ArrayList<>();
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        Human mother = new Human();
        mother.name = "E";
        mother.sex = false;
        mother.age = 37;
        mother.children = new ArrayList<>();
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human grandfather1 = new Human();
        grandfather1.name = "F";
        grandfather1.sex = true;
        grandfather1.age = 70;
        grandfather1.children = new ArrayList<>();
        grandfather1.children.add(father);

        Human grandmother1 = new Human();
        grandmother1.name = "G";
        grandmother1.sex = false;
        grandmother1.age = 68;
        grandmother1.children = new ArrayList<>();
        grandmother1.children.add(father);

        Human grandfather2 = new Human();
        grandfather2.name = "H";
        grandfather2.sex = true;
        grandfather2.age = 69;
        grandfather2.children = new ArrayList<>();
        grandfather2.children.add(mother);

        Human grandmother2 = new Human();
        grandmother2.name = "I";
        grandmother2.sex = false;
        grandmother2.age = 68;
        grandmother2.children = new ArrayList<>();
        grandmother2.children.add(mother);

        System.out.println(grandfather1.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human {
        //write your code here

        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public String toString() {
            String text = "";
            text += "Name: " + this.name;
            text += ", sex: " + (this.sex ? "male" : "female");
            text += ", age: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", children: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
