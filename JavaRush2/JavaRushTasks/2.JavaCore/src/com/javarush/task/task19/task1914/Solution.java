package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        String str = byteArrayOutputStream.toString().trim();
        String[] strings = str.split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[2]);
        int c = 0;
        if (strings[1].equals("+")) {
            c = a + b;
            str = Integer.toString(a) + " + " + Integer.toString(b) + " = " + Integer.toString(c);
        }
        if (strings[1].equals("-")) {
            c = a - b;
            str = Integer.toString(a) + " - " + Integer.toString(b) + " = " + Integer.toString(c);
        }
        if (strings[1].equals("*")) {
            c = a * b;
            str = Integer.toString(a) + " * " + Integer.toString(b) + " = " + Integer.toString(c);
        }
        System.setOut(console);
        System.out.println(str);
    }


        /* Pattern pattern = Pattern.compile("\\d+");
        char[] arr = str.toCharArray();
        int a = 0;
        int b = 0;
        int c = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                if (flag == true) {
                    a = Character.getNumericValue(arr[i]);
                    flag = false;
                } else {
                    b = Character.getNumericValue(arr[i]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+') {
                c = a + b;
                str = Integer.toString(a) + " + " + Integer.toString(b) + " = " + Integer.toString(c);
            }
            if (arr[i] == '-') {
                c = a - b;
                str = Integer.toString(a) + " - " + Integer.toString(b) + " = " + Integer.toString(c);
            }
            if (arr[i] == '*') {
                c = a * b;
                str = Integer.toString(a) + " * " + Integer.toString(b) + " = " + Integer.toString(c);
            }
        }
        System.setOut(console);
        System.out.println(str);

         */


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

