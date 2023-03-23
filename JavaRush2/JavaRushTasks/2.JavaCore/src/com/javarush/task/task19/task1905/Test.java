package com.javarush.task.task19.task1905;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\s[w][o][r][l][d]\\s");
        String str = "+78(890)d8 world 7world6-87- world 90d";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
