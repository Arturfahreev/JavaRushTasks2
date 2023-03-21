package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (reader.ready()) {
                int key = reader.read();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println((char)(int)(entry.getKey()) + " " + entry.getValue());
            }
        }

        /**
         * С использованием массива
         *
         * int[] aSCII = new int[128];
         *         try (FileReader reader = new FileReader(args[0])) {
         *             while (reader.ready()) {
         *                 aSCII[reader.read()]++;
         *             }
         *         }
         *         for (int i = 0; i < aSCII.length; i++) {
         *             if (aSCII[i] != 0) {
         *                 System.out.println((char) i + " " + aSCII[i]);
         *             }
         *         }
         */
    }
}
