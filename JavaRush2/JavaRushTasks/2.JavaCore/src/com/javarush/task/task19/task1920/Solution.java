package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {

        /**
         * Решение с использованием Stream
         */

        String fileName = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            TreeMap<String, Double> treeMap = reader.lines()
                    .map(s -> s.split(" "))
                    .collect(Collectors.toMap(s -> s[0], s -> Double.parseDouble(s[1]), Double::sum, TreeMap::new));
            Double max = Collections.max(treeMap.values());
            treeMap.entrySet().stream().
                    filter(e -> e.getValue().equals(max)).forEach(e -> System.out.println(e.getKey()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        /** Решение с использованием treeMap
         *
         * String fileName = args[0];
         *         TreeMap<String, Double> treeMap =  new TreeMap<>();
         *         try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
         *             while (fileReader.ready()) {
         *                 String[] arr = fileReader.readLine().split(" ");
         *                 String key = arr[0];
         *                 Double value = Double.parseDouble(arr[1]);
         *                 if (!treeMap.containsKey(key)) {
         *                     treeMap.put(key, value);
         *                 } else {
         *                     Double newValue = treeMap.get(key);
         *                     treeMap.put(key, value + newValue);
         *                 }
         *             }
         *         } catch (IOException e) {
         *             throw new RuntimeException(e);
         *         }
         *
         *         double doubleMax = Double.MIN_VALUE;
         *         for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
         *             double value = entry.getValue();
         *             if (value > doubleMax) {
         *                 doubleMax = value;
         *             }
         *         }
         *
         *         for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
         *             if (entry.getValue().equals(doubleMax)) {
         *                 System.out.println(entry.getKey());
         *             }
         *         }
         *
         *
         */


    }
}
