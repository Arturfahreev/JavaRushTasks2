package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = "";
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(str = bf.readLine()).equals("exit")) {
                if (str.contains(".")) {
                    try {
                        Double dob = Double.parseDouble(str);
                        print(dob);
                    } catch (NumberFormatException exc) {
                        print(str);
                    }
                } else {
                    try {
                        Integer count = Integer.parseInt(str);
                        if (count > 0 && count < 128) {
                            short sch = Short.parseShort(str);
                            print(sch);
                        }
                        if ((count < 0) || (count > 127) || (count == 0)) {
                            print(count);
                        }

                    } catch (NumberFormatException exc) {
                        print(str);
                    }
                }
            }

        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
