package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileStr = null;
        String fileName = null;
        Map<Integer, Integer[]> map = new TreeMap<Integer, Integer[]>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(fileStr = console.readLine()).equals("end")) {
                String[] arr = fileStr.split("\\.part");
                fileName = arr[0];
                arr = fileStr.split("\\.");
                String part = arr[arr.length - 1];
                int partNumber = Integer.parseInt(part.substring(4));
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileStr))) {
                    Integer[] arrInt = new Integer[bis.available()];
                    int i = 0;
                    while (bis.available() > 0) {
                        arrInt[i] = bis.read();
                        i++;
                    }
                    map.put(partNumber, arrInt);
                }
            }
        }

        if (fileName != null) {
            File file = new File(fileName);
            try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file))) {
                for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
                    Integer[] arr = entry.getValue();
                    byte[] byteArr = new byte[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        byteArr[i] = arr[i].byteValue();
                    }
                    writer.write(byteArr);
                }
            }
        }

        /**
         * Решение с использованием TreeSet
         */
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Set<String> files = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String[] parts1 = o1.split(".part");
//                String[] parts2 = o2.split(".part");
//                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
//                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
//                return number1 - number2;
//            }
//        });
//        String outputFile = null;
//        String readString;
//        while (!(readString = reader.readLine()).equals("end")) {
//            files.add(readString);
//            if (outputFile == null) {
//                int indexOfSuffix = readString.lastIndexOf(".part");
//                outputFile = readString.substring(0, indexOfSuffix);
//            }
//        }
//        if (outputFile == null) return;
//        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
//            for (String file : files) {
//                try (FileInputStream fileInputStream = new FileInputStream(file)) {
//                    byte[] buffer = new byte[fileInputStream.available()];
//                    while (fileInputStream.available() > 0) {
//                        int bytesRead = fileInputStream.read(buffer);
//                        fileOutputStream.write(buffer, 0, bytesRead);
//                    }
//                }
//            }
//        }
    }
}
