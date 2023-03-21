package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf('?');
        url = url.substring(index + 1);
        String[] arr = url.split("&");
        List<String> listStr = new ArrayList<>();
        List<Double> listDouble = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.contains("=")) {
                String[] arrStr = str.split("=");
                if (arrStr[0].contains("obj")) {
                    try {
                        Double dbl = Double.parseDouble(arrStr[1]);
                        listDouble.add(dbl);
                    } catch (NullPointerException e) {

                    } catch (NumberFormatException e) {
                        listStr.add(arrStr[1]);
                    }

                }
                System.out.print(arrStr[0] + " ");
            } else {
                System.out.print(str + " ");
            }
        }
        System.out.println();
        if (listDouble.size() > 0) {
            for (int i = 0; i < listDouble.size(); i++) {
                alert(listDouble.get(i));
            }
        }
        if (listStr.size() > 0) {
            for (int i = 0; i < listStr.size(); i++) {
                alert(listStr.get(i));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
