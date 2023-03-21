package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bf.readLine();
            //fileName = "/Users/anuar/IdeaProjects/JavaRush2/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1922/text.txt";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            while (bf.ready()) {
                String strOrigin = bf.readLine();
                String[] arr = strOrigin.split(" ");
                int count = 0;
                for (int i = 0; i < words.size(); i++) {
                    String str = words.get(i);
                    for (int j = 0; j < arr.length; j++) {
                        if (str.equals(arr[j])) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    System.out.println(strOrigin);
                }

                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
