package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        }

        try (FileInputStream reader = new FileInputStream(file)) {
            int i = 0;
            Integer[] arrInteger = new Integer[reader.available()];
            while (reader.available() > 0) {
                arrInteger[i] = reader.read();
                i++;
            }

            Map<Integer, Integer> map = Arrays.stream(arrInteger)
                    .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum, HashMap::new));
//                    .map(s -> { ArrayList<Integer> list = new ArrayList<>();
//                        list.add(s);
//                        list.add(1);
//                        return list;
//                    })list
//                    .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum, HashMap::new ));

            int min = Collections.min(map.values());
            map.entrySet().stream()
                    .filter(s -> s.getValue().equals(min))
                    .forEach(s -> System.out.print(s.getKey() + " "));
        }
    }
}
