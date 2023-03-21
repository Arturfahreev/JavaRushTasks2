package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = "";
            while (!(str = reader.readLine()).equals("exit")) {
                ReadThread readThread = new ReadThread(str);
                readThread.start();
            }
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run () {

            try (FileInputStream fis = new FileInputStream(this.fileName)) {
                int[] arr = new int[256];
                while (fis.available() > 0) {
                    arr[fis.read()]++;
                }
                int maxCount = Integer.MIN_VALUE;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > maxCount) maxCount = arr[i];
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == maxCount) {
                        resultMap.put(this.fileName, i);
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
