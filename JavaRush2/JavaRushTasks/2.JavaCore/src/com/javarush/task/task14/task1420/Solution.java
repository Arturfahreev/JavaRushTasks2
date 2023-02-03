package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int result = 1;

        for (int i = 2; i < (Math.max(a, b) / 2); i++ ) {
            if ( a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        System.out.println(result);
        reader.close();
    }
}
