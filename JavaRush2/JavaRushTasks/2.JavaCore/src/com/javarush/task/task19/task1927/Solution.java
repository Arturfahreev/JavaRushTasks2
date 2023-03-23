package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(console);
        String str = byteArrayOutputStream.toString();
        String[] arr = str.split("\\n");


        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(arr[i]);
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
            //System.out.println("fifth");
            //System.out.println("okey");
            //System.out.println("okeyPC");
            //System.out.println("okeyMac);
        }
    }
}
