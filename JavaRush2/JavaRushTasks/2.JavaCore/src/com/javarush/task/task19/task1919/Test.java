package com.javarush.task.task19.task1919;

public class Test {
    public static void main(String[] args) {
        String str = "13.556";
        Double dobl = Double.parseDouble(str);
        double d = 13.5;
        System.out.printf("%.1f", dobl);
    }
}
