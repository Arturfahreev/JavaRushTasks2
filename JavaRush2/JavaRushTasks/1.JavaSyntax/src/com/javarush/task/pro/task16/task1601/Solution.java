package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(90, 1,1);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String[] days = {"воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота" };
        for (int i = 0; i < days.length; i++) {
            if (date.getDay() == i) {
                return days[i];
            }
        }
        //напишите тут ваш код

        return null;
    }
}
