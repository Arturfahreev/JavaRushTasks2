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
            for (int i = 0; i < Math.min(list1.size(), list2.size()); ) {
                String line1List1 = list1.get(i);
                String line2List1 = list1.get(i + 1);
                //String line3List1 = list1.get(i + 2);

                String line1List2 = list2.get(i);
                String line2List2 = list2.get(i + 1);
                //String line3List2 = list2.get(i + 2);
//                строка1         строка1            SAME строка1
//                строка2         строка3            REMOVED строка2
//                строка3         строка5            SAME строка3
//                строка4         строка0           REMOVED строка4
//                строка5         строка1           SAME строка5
//                строка1          строка3            ADDED строка0
//                 строка2         строка4                SAME строка1
//                 строка3         строка5              REMOVED строка2
//                 строка5                              SAME строка3
//                 строка0                             ADDED строка4
//                                                   SAME строка5
//                                                    REMOVED строка0





                if (line1List1.equals(line1List2)) {
                    lines.add(new LineItem(Type.SAME, line1List1));
                    i++;
                    continue;
                } else if (line2List1.equals(line1List2)) {
                    lines.add(new LineItem(Type.REMOVED, line1List1));
                    lines.add(new LineItem(Type.SAME, line2List1));
                    i += 2;
                    continue;
                }
            }


            String line1File1;
            String line1File2;
            String line2File1;
            String line2File2;
            while (reader1.ready() || reader2.ready()) {
                if (reader1.ready() && reader2.ready()) {
                    line1File1 = reader1.readLine();
                    line1File2 = reader2.readLine();
                    if (line1File1.equals(line1File2)) {
                        lines.add(new LineItem(Type.SAME, line1File1));
                    } else {
                        line2File1 = reader1.readLine();
                        line2File2 = reader2.readLine();
                        if (line2File1.equals(line1File2)) {
                            lines.add(new LineItem(Type.REMOVED, line1File1));
                            lines.add(new LineItem(Type.SAME, line2File1));
                        }
                    }
                }
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
    }
}
