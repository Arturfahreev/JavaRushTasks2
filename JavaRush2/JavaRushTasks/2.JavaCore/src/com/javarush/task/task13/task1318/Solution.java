package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        try (FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            while (bufferedReader.ready()) {
                int length = 128;
                char[] array = new char[128];
                int count = bufferedReader.read(array, 0, length );
                System.out.print(array);
            }
            
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}