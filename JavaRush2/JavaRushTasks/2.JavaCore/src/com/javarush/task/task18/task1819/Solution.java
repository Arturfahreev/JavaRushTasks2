package com.javarush.task.task18.task1819;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = "";
        String file2 = "";

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bf.readLine();
            file2 = bf.readLine();
        }

        try (FileInputStream fileInputStream1 = new FileInputStream(file1)) {
            byte[] arr1 = new byte [fileInputStream1.available()];
            int length1 = fileInputStream1.read(arr1);

            try (FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
                 FileInputStream fileInputStream2 = new FileInputStream(file2)) {
                while (fileInputStream2.available() > 0) {
                    fileOutputStream1.write(fileInputStream2.read());
                }
                fileOutputStream1.write(arr1);

            }
        }
    }
}
