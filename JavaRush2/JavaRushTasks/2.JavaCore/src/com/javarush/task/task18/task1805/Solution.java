package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) {
        String file = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))) {
            List<Integer> list = new ArrayList<>();
            while (reader.available() > 0) {
                list.add(reader.read());
            }
           list.stream().distinct().sorted().forEach(x -> System.out.print(x + " "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// Решение с использованием TreeSet
//
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        try (FileInputStream reader = new FileInputStream(file)) {
//            while (reader.available() > 0) {
//                treeSet.add(reader.read());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        for (Integer integer : treeSet) {
//            System.out.print(integer + " ");
//        }
    }
}
