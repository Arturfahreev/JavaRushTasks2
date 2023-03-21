package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = args[0];
        //String fileName1 = "/Users/anuar/IdeaProjects/JavaRush2/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/file1.txt";
        String fileName2 = args[1];
        //String fileName2 = "/Users/anuar/IdeaProjects/JavaRush2/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/file2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            while (reader.ready()) {
                String str = reader.readLine();
                String[] arr = str.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].matches(".*\\d.*")) {
                        writer.write(arr[i] + " ");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
