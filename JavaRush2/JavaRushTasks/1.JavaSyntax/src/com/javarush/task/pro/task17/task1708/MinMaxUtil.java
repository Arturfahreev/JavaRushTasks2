package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int max (int a, int b) {
        int[] arr = new int[]{a, b};
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max (int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max (int a, int b, int c, int d) {
        int[] arr = new int[]{a, b, c, d};
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max (int a, int b, int c, int d, int e) {
        int[] arr = new int[]{a, b, c, d, e};
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int min (int a, int b) {
        int[] arr = new int[]{a, b};
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int min (int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int min (int a, int b, int c, int d) {
        int[] arr = new int[]{a, b, c, d};
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int min (int a, int b, int c, int d, int e) {
        int[] arr = new int[]{a, b, c, d, e};
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                max = arr[i];
            }
        }
        return max;
    }

}
