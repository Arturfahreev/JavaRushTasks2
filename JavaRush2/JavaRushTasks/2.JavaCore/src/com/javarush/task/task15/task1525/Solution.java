package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try (BufferedReader bf = new BufferedReader(new FileReader(Statics.FILE_NAME))) {
            while (bf.ready()) {
                String str = bf.readLine();
                lines.add(str);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
