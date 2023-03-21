package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String file1 = args[0];
        String file2 = args[1];

        /**
         * С использованием Stream
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            writer.write(reader.lines()
                    .map(e -> e.split(" "))
                    .flatMap(e -> Arrays.stream(e).filter(s -> s.length() > 6))
                    .collect(Collectors.joining(",")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * С использованием ArrayList
         *
         * List<String> stringList = new ArrayList<>();
         *         try (BufferedReader reader = new BufferedReader(new FileReader(file1));
         *             BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
         *             while (reader.ready()) {
         *                 String str = reader.readLine();
         *                 String[] arr = str.split(" ");
         *                 for (int i = 0; i < arr.length; i++) {
         *                     if (arr[i].length() > 6) {
         *                         stringList.add(arr[i]);
         *                     }
         *                 }
         *             }
         *
         *             for (int i = 0; i < stringList.size(); i++) {
         *                 if (i != stringList.size() - 1) {
         *                     writer.write(stringList.get(i) + ",");
         *                 } else {
         *                     writer.write(stringList.get(i));
         *                 }
         *             }
         *         } catch (IOException e) {
         *             throw new RuntimeException(e);
         *         }
         *
         */



    }
}
