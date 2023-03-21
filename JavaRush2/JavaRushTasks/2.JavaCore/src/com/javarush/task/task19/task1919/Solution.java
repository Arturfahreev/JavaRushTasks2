package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        /**
         * Решение с использованием TreeMap
         */

        String fileName = null;
        if (args.length >= 1) {
            fileName = args[0];
        }

        TreeMap<String, Double> map = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String str = "";
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                String[] arrString = str.split(" ");
                String keyString = arrString[0];
                String string1 = arrString[1];
                Double valueDouble = Double.parseDouble(string1);
                if (!map.containsKey(keyString)) {
                    map.put(keyString, valueDouble);
                } else {
                    Double doubleSum = map.get(keyString) + valueDouble;
                    map.put(keyString, doubleSum);
                }
                map.put(arrString[0], Double.parseDouble(arrString[1]));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));

        /**
         *
         * Решение с ArrayList
         *
        String fileName = null;
        if (args.length >= 1) {
            fileName = args[0];
        }
        List<String> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine()); //считали с файла строки в list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Double> listDouble = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] arrList = list.get(i).split(" ");
            list.set(i, arrList[0]);
            listDouble.add(Double.parseDouble(arrList[1])); //разделили на list и listDouble
        }
        List<String> listResult = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    double x = listDouble.get(i);
                    x += listDouble.get(j);
                    listDouble.set(j, 0.0);
                    listDouble.set(i, x);
                    list.set(j, "");// нашли повторы
                }
            }
        }
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("")) {
                str = list.get(i) + " " + String.valueOf(listDouble.get(i));
                listResult.add(str); // создаем list с итоговыми значениями
            }
        }
        Collections.sort(listResult);
        for (String string : listResult) {
            String[] arr = string.split(" ");
            System.out.println(arr[0] + " " + Double.parseDouble(arr[1])); // вытаскиваем из итогового list значения
        }
         */

    }
}
