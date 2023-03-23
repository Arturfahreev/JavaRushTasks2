package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {
            String[] arr = null;
            long number;
            while (reader.ready()) {
                arr = reader.readLine().split(" ");
                for (int i = 0; i < arr.length; i++) {
                    try {
                        number = Long.parseLong(arr[i]);
                        writer.write(number + " ");
                    } catch (NumberFormatException exc) {
                        continue;
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
