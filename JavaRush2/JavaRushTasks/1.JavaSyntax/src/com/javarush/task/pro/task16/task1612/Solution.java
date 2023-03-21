package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> set = new HashSet<>();
        for (Map.Entry<LocalDate, List<LocalTime>> entry : sourceMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                LocalTime localTime = entry.getValue().get(i);
                LocalDate localDate = entry.getKey();
                set.add(LocalDateTime.of(localDate, localTime));
            }
        }
        /**
         * Более сокращенный вариант
         *
         * for (var tmp: sourceMap.entrySet()) {
         *      for (var tmp1: sourceMap.get(tmp.getKey())) {
         *           result.add(LocalDateTime.of(tmp.getKey(), tmp1));
         *      }
         * }
         */
        return set;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}
