package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        }
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))) {
            List<Integer> list = new ArrayList<>();
            Scanner sc = new Scanner(reader);
            while (sc.hasNextInt()) {
                int intNumber = sc.nextInt();
                if (intNumber % 2 == 0) {
                    list.add(intNumber);
                }
            }
            Collections.sort(list);
            for (Integer number : list) {
                System.out.println(number);
            }
        }
    }
}
