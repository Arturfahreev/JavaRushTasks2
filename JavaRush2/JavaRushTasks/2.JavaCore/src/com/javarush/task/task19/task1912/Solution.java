package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        testString.printSomething();

        String str = byteArrayOutputStream.toString();
        byteArrayOutputStream.reset();
        /* char[] arr = str.toCharArray();

        for (int i = 0; i < args.length; i++) {
            if (arr[i] == 't') {
                arr[i] = '?';
            }
        }
        String result = String.valueOf(arr); */

        System.setOut(console);

        System.out.println(str.replace("te", "??"));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
