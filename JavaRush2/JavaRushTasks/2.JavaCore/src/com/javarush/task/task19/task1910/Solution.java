package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2))) {
            while (bufferedReader.ready()) {
                bufferedWriter.write(bufferedReader.readLine().replaceAll("\\p{Punct}", ""));
            }
        }
    }
}
