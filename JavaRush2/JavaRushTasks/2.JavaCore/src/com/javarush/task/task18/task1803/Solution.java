package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        }
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))) {
            int[] arr = new int[reader.available()];
            int j = 0;
            while (reader.available() > 0) {
                arr[j] = reader.read();
                j++;
            }

            int[] bytes = new int[255];
            for (int i = 0; i < arr.length; i++) {
                int b = arr[i];
                bytes[b] = bytes[b] + 1;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > max) {
                    max = bytes[i];
                }
            }
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == max) {
                    System.out.print(i + " ");
                }
            }

        }
    }
}
