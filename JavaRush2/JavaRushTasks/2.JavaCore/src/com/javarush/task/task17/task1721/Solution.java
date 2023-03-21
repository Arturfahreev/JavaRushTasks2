package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader reader2 = new BufferedReader(new FileReader(fileName2))) {
            while (reader1.ready()) {
                allLines.add(reader1.readLine());
            }
            while (reader2.ready()) {
                forRemoveLines.add(reader2.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException ex) {

        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
