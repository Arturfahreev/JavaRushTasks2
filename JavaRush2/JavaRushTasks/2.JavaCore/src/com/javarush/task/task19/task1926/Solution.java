package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String file = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * Решение с использованием Stream
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines()
                    .map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .forEach(System.out::println);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }


        /**
         * Решение с использованием StringBuilder
         *
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while (reader.ready()) {
                StringBuilder stringBuilder = new StringBuilder();
                System.out.println(stringBuilder.append(reader.readLine()).reverse());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
    }

}
