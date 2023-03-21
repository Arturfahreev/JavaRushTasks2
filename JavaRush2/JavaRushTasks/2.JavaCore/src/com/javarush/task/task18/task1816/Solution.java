package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(args[0])) {
            int count = 0;
            while (fis.available() > 0) {
                byte b = (byte) fis.read();
                if ((b >= 'A'& b <= 'Z') || (b >= 'a' & b <= 'z')) {
                    count++;
                }
            }
            System.out.println(count);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
