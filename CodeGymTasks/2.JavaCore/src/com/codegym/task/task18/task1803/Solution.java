package com.codegym.task.task18.task1803;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Most frequent bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileStream = new FileInputStream(file);
        
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
        Integer nextByte, count, maxBytes = Integer.MIN_VALUE;
        while(fileStream.available() > 0) {
            nextByte = fileStream.read();
            count = list.getOrDefault(nextByte, 0);
            count++;
            list.put(nextByte, count);
            if (count > maxBytes) {
                maxBytes = count;
            }
        }
        fileStream.close();
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            if (entry.getValue().equals(maxBytes)) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
