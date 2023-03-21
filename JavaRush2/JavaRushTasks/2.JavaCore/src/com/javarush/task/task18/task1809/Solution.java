package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fis1 = new FileInputStream(bf.readLine());
             FileOutputStream fos2 = new FileOutputStream(bf.readLine())) {
            byte[] arr1 = new byte[fis1.available()];
            fis1.read(arr1);
            for (int i = arr1.length - 1; i >= 0; i--) {
                fos2.write(arr1[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
