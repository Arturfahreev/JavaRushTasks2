package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String[] arr = null;
            while (reader.ready()) {
                arr = reader.readLine().split(" ");
                int year = Integer.parseInt(arr[arr.length - 1]);
                int month = Integer.parseInt(arr[arr.length - 2]);
                int day = Integer.parseInt(arr[arr.length - 3]);
                String name = "";
                for (int i = 0; i < arr.length - 3; i++) {
                    name = name + arr[i] + " ";
                }
                name = name.trim();
                Date date = new GregorianCalendar(year, month - 1, day).getTime();
                PEOPLE.add(new Person(name, date));
            }
        }

    }
}
