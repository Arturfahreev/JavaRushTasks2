package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(args[0])) {
            int allCount = 0;
            int countSpace = 0;
            while (fileReader.ready()) {
                char x = (char) fileReader.read();
                if (Character.isSpaceChar(x)) {
                    countSpace++;
                }
                allCount++;
            }

            double result = ((double) countSpace / (double) allCount) * 100;
            System.out.printf("%.2f", result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
