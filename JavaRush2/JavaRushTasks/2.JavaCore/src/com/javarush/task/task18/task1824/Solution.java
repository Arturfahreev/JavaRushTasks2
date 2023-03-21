package com.javarush.task.task18.task1824;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (true) {
            try {
                str = bf.readLine();
                FileInputStream fis = new FileInputStream(str);
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(str);
                break;
            }
        }
    }
}
