package com.codegym.task.task09.task0924;

import java.util.ArrayList;

/* 
A scary fairy tale

*/

public class Solution {
    public static RedRidingHood hood = new RedRidingHood();
    public static Grandmother grandmother = new Grandmother();
    public static Pie pie = new Pie();
    public static Woodcutter woodcutter = new Woodcutter();
    public static Wolf wolf = new Wolf();

    public static void main(String[] args) {
        // write your code here

        wolf.killed.add(grandmother);
        wolf.ate.add(grandmother);
        wolf.killed.add(hood);
        wolf.ate.add(hood);

        woodcutter.killed.add(wolf);
        woodcutter.ate.add(wolf);

//        wolf.ate.add(pie);
    }

    // Red riding hood
    public static class RedRidingHood extends StoryItem {
    }

    // Grandmother
    public static class Grandmother extends StoryItem {
    }

    // Pie
    public static class Pie extends StoryItem {
    }

    // Woodcutter
    public static class Woodcutter extends StoryItem {
    }

    // Wolf
    public static class Wolf extends StoryItem {
    }

    public static abstract class StoryItem {
        public ArrayList<StoryItem> killed = new ArrayList<>();
        public ArrayList<StoryItem> ate = new ArrayList<>();
    }
}
