package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.intVar);
        System.out.println(slt.doubleVar);
        System.out.println(slt.DoubleVar);
        System.out.println(slt.booleanVar);
        System.out.println(slt.ObjectVar);
        System.out.println(slt.ExceptionVar);
        System.out.println(slt.StringVar);

    }
}
