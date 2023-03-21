package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            int min = Integer.MAX_VALUE;
            while (fis.available() > 0) {
                int x = fis.read();
                if (x < min) {
                    min = x;
                }
            }
            System.out.println(min);
        }

    }
}
