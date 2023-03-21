package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = "/Users/anuar/IdeaProjects/JavaRush2/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/file1.txt";
        String file2 = "/Users/anuar/IdeaProjects/JavaRush2/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/file2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
            FileWriter writer = new FileWriter(file2)) {
            while (reader.ready()) {
                String[] arr = reader.readLine().split(" ");
                for (String value : arr) {
                    writer.write(Math.round(Double.parseDouble(value)) + " ");
                }
                writer.write("\n");
            }

        }

        /**
         * Решение с использованием Scanner
         *
         String file1;
        String file2;
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
         }

         String result = "";
        try (
             FileReader reader = (new FileReader(file1));
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextDouble()) {
                double d = scanner.nextDouble();
                long l = Math.round(d);
                result += l + " ";
            }
        }
        try (FileWriter writer = new FileWriter(file2)) {
            writer.write(result);
        }
         */
    }
}
