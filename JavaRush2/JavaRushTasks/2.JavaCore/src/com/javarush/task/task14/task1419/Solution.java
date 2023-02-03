package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static class Exception1 extends Exception {}
    public static class Exception2 extends Exception {}
    public static class Exception3 extends Exception {}
    public static class Exception4 extends Exception {}
    public static class Exception5 extends Exception {}
    public static class Exception6 extends Exception {}
    public static class Exception7 extends Exception {}
    public static class Exception8 extends Exception {}
    public static class Exception9 extends Exception {}



    public static void main(String[] args) {
        exceptions.add(new Exception1() );
        exceptions.add(new Exception2());
        exceptions.add(new Exception3());
        exceptions.add(new Exception4());
        exceptions.add(new Exception5());
        exceptions.add(new Exception6());
        exceptions.add(new Exception7());
        exceptions.add(new Exception8());
        exceptions.add(new Exception9());
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
