package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(console.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(console.readLine()))) {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            while (reader1.ready()) {
                list1.add(reader1.readLine());
            }
            while (reader2.ready()) {
                list2.add(reader2.readLine());
            }

            String line1List1 = "";
            String line2List1 = "";
            String line1List2 = "";
            String line2List2 = "";

            while(list1.size() > 0 && list2.size() > 0) {
                line1List1 = list1.get(0);
                if (list1.size() > 1) {
                    line2List1 = list1.get(1);
                }

                line1List2 = list2.get(0);
                if (list2.size() > 1) {
                    line2List2 = list2.get(1);
                }

                if (line1List1.equals(line1List2)) {
                    lines.add(new LineItem(Type.SAME, line1List1));
                    list1.remove(0);
                    list2.remove(0);

                } else if (line2List1.equals(line1List2)) {
                    lines.add(new LineItem(Type.REMOVED, line1List1));
                    list1.remove(line1List1);

                } else if (line1List1.equals(line2List2)) {
                    lines.add(new LineItem(Type.ADDED, line1List2));
                    list2.remove(line1List2);
                }
            }
            if (list1.isEmpty() && !list2.isEmpty()) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
            }
            if (!list1.isEmpty() && list2.isEmpty()) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
            }
            for (LineItem lineItem : lines) {
                System.out.println(lineItem.getLine());

            }

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        public String getLine () {
            return this.type + " " + this.line;
        }
    }
}

//                строка1         строка1            SAME строка1
//                строка2         строка3            REMOVED строка2
//                строка3         строка5            SAME строка3
//                строка4         строка0            REMOVED строка4
//                строка5         строка1            SAME строка5
//                строка1         строка3            ADDED строка0
//                строка2         строка4            SAME строка1
//                строка3         строка5            REMOVED строка2
//                строка5                            SAME строка3
//                строка0                            ADDED строка4
//                                                   SAME строка5
//                                                   REMOVED строка0

