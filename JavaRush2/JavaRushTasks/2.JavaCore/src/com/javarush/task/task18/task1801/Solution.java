package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        try (FileInputStream fileInputStream = new FileInputStream(str)) {
            int max = Integer.MIN_VALUE;
            while (fileInputStream.available() > 0) {
                int x = fileInputStream.read();
                if (x > max) {
                    max = x;
                }
            }
            System.out.println(max);
        }

    }
}
