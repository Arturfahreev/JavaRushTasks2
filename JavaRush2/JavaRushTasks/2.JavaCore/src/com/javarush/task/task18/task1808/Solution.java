package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException  {
        String file1 = null;
        String file2 = null;
        String file3 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
        }
        try (FileInputStream reader = new FileInputStream(file1);
            FileOutputStream writer2 = new FileOutputStream(file2);
            FileOutputStream writer3 = new FileOutputStream(file3)) {
            int bytesNumber = reader.available();
            byte[] arrBytesFile1 = new byte[bytesNumber];
            reader.read(arrBytesFile1);
            if (bytesNumber % 2 == 0) {
                for (int i = 0; i < arrBytesFile1.length / 2; i++) {
                    writer2.write(arrBytesFile1[i]);
                }
                for (int i = arrBytesFile1.length / 2; i < arrBytesFile1.length; i++) {
                    writer3.write(arrBytesFile1[i]);
                }
            } else {
                for (int i = 0; i <= arrBytesFile1.length / 2; i++) {
                    writer2.write(arrBytesFile1[i]);
                }
                for (int i = arrBytesFile1.length / 2 + 1; i < arrBytesFile1.length; i++) {
                    writer3.write(arrBytesFile1[i]);
                }
            }
        }


    }
}
