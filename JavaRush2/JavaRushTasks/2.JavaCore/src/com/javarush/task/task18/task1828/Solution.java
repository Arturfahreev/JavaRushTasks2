package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String file = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (args.length == 0) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            String id = null;
            while (reader.ready()) {
                line = reader.readLine();
                id = line.substring(0, 8).trim();
                if (args[1].equals(id)) {
                    if (args[0].equals("-u")) {
                        String str = String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]);
                        list.add(str);
                        continue;
                    }
                    if (args[0].equals("-d")) {
                        continue;
                    }
                }
                list.add(line);
            }
        }
        catch (IOException exc) {

        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

