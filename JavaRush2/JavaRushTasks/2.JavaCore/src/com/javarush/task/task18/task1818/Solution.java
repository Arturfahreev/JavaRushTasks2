package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
        String file3 = "";
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bf.readLine();
            file2 = bf.readLine();
            file3 = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileWriter fileWriter1 = new FileWriter(file1, true);
             FileReader fileReader2 = new FileReader(file2);
             FileReader fileReader3 = new FileReader(file3)) {
            while (fileReader2.ready()) {
                fileWriter1.write(fileReader2.read());
            }
            while (fileReader3.ready()) {
                fileWriter1.write(fileReader3.read());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

