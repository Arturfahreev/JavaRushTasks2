package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(file1));
             BufferedWriter bfw = new BufferedWriter(new FileWriter(file2))) {
            while (bfr.ready()) {
                char x = (char)bfr.read();
                if (x == '.') {
                    bfw.write('!');
                } else {
                    bfw.write(x);
                }
            }
        }
    }
}
