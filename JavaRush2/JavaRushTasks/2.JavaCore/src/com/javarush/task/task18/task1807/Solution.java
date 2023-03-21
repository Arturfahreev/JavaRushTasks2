package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (FileInputStream fileInputStream = new FileInputStream(sc.nextLine())) {
            int count = 0;
            while ( fileInputStream.available() > 0) {
                int x = fileInputStream.read();

                if (x == (byte) ',') {
                    count++;
                }
            }
            System.out.println(count);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
