package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        String nameFile = sc.nextLine();
        String exit = "exit";

        try (FileInputStream fileInputStream = new FileInputStream(nameFile);
             InputStreamReader reader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(reader);

             FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
             ) {

            while (!sc.nextLine().equals(exit)) {
                Path path = Path.of(nameFile);

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }



    }
}
