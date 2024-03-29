package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))) {
            String str = null;
            while (true) {
                str = reader.readLine();
                if (str.equals("exit")) {
                    writer.write(str + "\n");
                    break;
                }
                writer.write(str + "\n");
            }
        }
    }
}
