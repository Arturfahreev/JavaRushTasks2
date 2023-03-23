package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            int count = 0;
            String str = null;
            StringBuilder strBuilder = new StringBuilder();
            Pattern pattern = Pattern.compile("\\bworld\\b");
            while (reader.ready()) {
                Matcher matcher = pattern.matcher(reader.readLine());
                while (matcher.find()) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
