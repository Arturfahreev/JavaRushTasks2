package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            if (args.length == 0) {
                return;
            }

                while (reader.ready()) {
                    String line = reader.readLine();
                    String[] arr = line.split(" ");
                    if (args[0].equals(arr[0].trim())) {
                        System.out.println(line);
                        break;
                    }
                }
        }
    }
}
