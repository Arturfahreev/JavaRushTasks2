package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static String tag = "";

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            if (args.length != 0) {
                tag = args[0];
                while (reader.ready()) {
                    stringBuilder.append(reader.readLine().trim());
                }
                TreeMap<Integer, String> map = new TreeMap<>();
                //String regex = "(<" + tag + ".*?>.*?(?<one><" + tag + ">.*?</" + tag + ")?.*?</" + tag + ">)(?=<[^/]\\w*?>|$)";
                //String regex = "((<" + tag + ".*?>.*?(<" + tag + ">.*?</" + tag + ">).*?</" + tag + ">)(?=<[^/]\\w*?>|$))|((<" + tag + ".*?>.*?</" + tag + ">)(?=<[^/]\\w*?>|$))";
                //String regex = "((<span.*?>.*(<span>.*</span>).*</span>)(?=<[^/]\\w*?>|$))|((<span.*>.*</span>)(?=<[^/]\\w*?>|$))";
                //String regex = "(.*?)(<span[^>]*?>)(.*?)(<span>.*?[^s][^p][^a][^n].*?</span>)(.*?){1,}(</span>)|(.*?<span>.*?</span>)";
                char[] charArr = tag.toCharArray();
                String insert = "";
                for (int l = 0; l < charArr.length; l++) {
                    insert += "[^" + charArr[l] + "]*?";
                }
                //String regex1 = "(<span[^>]*?>[^s]*?[^p]*?[^a]*?[^n]*?</span>)";
                String regex1 = "(<" + tag + "[^>]*?>" + insert + "</" + tag + ">)";
                Pattern pattern = Pattern.compile(regex1);
                String str = stringBuilder.toString().replaceAll("[\\n\\r]", "");
                Matcher matcher = pattern.matcher(str);
                int i = 0;
                List<String> list = new ArrayList<>();
                boolean flag = false;
                int count = 0;
                while (matcher.find()) {
                    String group = matcher.group();
                    str = str.replaceFirst(group,"GROUP" + i + " "); //затирка группы на i в строке
                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        if (group.contains("GROUP" + (entry.getKey()) + " ")) {
                            if (flag == false) flag = true;
                            count++;
//                            String value = entry.getValue();
//                            for (Map.Entry<Integer, String> entry1 : map.entrySet()) {
//                                if (entry1.getValue().contains(value)) {
//
//                                }
//                            }
                            String name = "GROUP" + entry.getKey() + " ";
                            group = group.replaceFirst(name, entry.getValue());
                        }
                    }

                    list.add(group);
                    if (flag) {
                        if (list.size() > count + 1) {
                            for (int n = 0; n < list.size() - 1 - count; n++) {
                                System.out.println(list.get(n));
                            }
                        }
                        System.out.println(list.get(list.size() - 1));
                        for (int j = list.size() - 1 - count; j < list.size() - 1; j++) {
                            System.out.println(list.get(j));
                        }
                        flag = false;
                        count = 0;
                        //i = 0;
                        list.clear();
                        //map.clear();
                        //matcher = pattern.matcher(str);
                        //continue;
                    }
                    map.put(i, group);
                    matcher = pattern.matcher(str);
                    i++;
                }
                if (list.size() > 0) {
                    for (int k = 0; k < list.size(); k++) {
                        System.out.println(list.get(k));
                    }
                }
            }
        }
    }
}
