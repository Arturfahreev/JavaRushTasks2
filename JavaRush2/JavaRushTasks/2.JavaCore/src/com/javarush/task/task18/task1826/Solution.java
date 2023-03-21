package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        if (args[0].equals("-e")) {
            try (FileInputStream fis = new FileInputStream(args[1]);
                 FileOutputStream fos2 = new FileOutputStream(args[2])) {
                while (fis.available() > 0) {
                    int x = fis.read();
                    x = x - 1;
                    fos2.write(x);
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (args[0].equals("-d")) {
            try (FileInputStream fis = new FileInputStream(args[1]);
                 FileOutputStream fos2 = new FileOutputStream(args[2])) {
                while (fis.available() > 0) {
                    int x = fis.read();
                    x = x + 1;
                    fos2.write(x);
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

}
