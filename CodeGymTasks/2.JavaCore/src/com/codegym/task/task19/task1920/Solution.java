package com.codegym.task.task19.task1920;

/* 
The richest

*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            Map<String, Double> map = new HashMap<>();
            List<String> names = new ArrayList<>();
            Double value = 0.0;

            while(bufferedReader.ready()) {

                String[] values = bufferedReader.readLine().split(" ");
                if (!map.containsKey(values[0])) {
                    map.put(values[0], 0.0);
                }
                map.put(values[0], map.get(values[0]) + Double.parseDouble(values[1]));
            }
            bufferedReader.close();

            for (Map.Entry<String, Double> entrySet : map.entrySet()) {
                if (entrySet.getValue() > value) {
                    value = entrySet.getValue();
                }
            }

            for (Map.Entry<String, Double> entrySet : map.entrySet()) {
                if (entrySet.getValue().equals(value)) {
                    names.add(entrySet.getKey());
                }
            }

            String[] nameList = names.toArray(new String[0]);
            Arrays.sort(nameList);
            for (String name : nameList) {
                System.out.println(name);
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
