package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();
        try (FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2)) {
            int i = 1;
            while (fileReader.ready()) {
                char x = (char) fileReader.read();
                if (i % 2 == 0) {
                    fileWriter.write(x);
                }
                i++;
            }
        }
    }
}
