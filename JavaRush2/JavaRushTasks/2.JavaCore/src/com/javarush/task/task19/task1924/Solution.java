package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            String str = "";
            while (reader.ready()) {
                str = reader.readLine();
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    str = str.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(str);
            }

//            Pattern pattern = Pattern.compile("\\b\\d+\\W?\\b");
//            String subStr = "";
//            while (reader.ready()) {
//                str = reader.readLine();
//                Matcher matcher = pattern.matcher(str);
//                while (matcher.find()) {
//                    int start = matcher.start();
//                    int end = matcher.end();
//                    subStr = str.substring(start, end);
//                    System.out.println(subStr);
//                    try {
//                        int number = Integer.parseInt(subStr);
//                        if (map.containsKey(number)) {
//                                System.out.println(str.replace(String.valueOf(number), map.get(number)));
//                            }
//
//                    } catch (NumberFormatException exc) {
//                        subStr = subStr.substring(0, subStr.length() - 1);
//                        int number = Integer.parseInt(subStr);
//                        if (map.containsKey(number)) {
//                            System.out.println(str.replace(String.valueOf(number), map.get(number)));
//                        }
//                    }
//                }
//                System.out.println(str);
        }
    }
}

