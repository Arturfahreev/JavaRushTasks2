package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (args.length == 0) {
                return;
            }
            if (args[0].equals("-c") && args.length == 4) {
                String name = args[1];
                double price = Double.parseDouble(args[2]);
                int quantity = Integer.parseInt(args[3]);
                int maxId = Integer.MIN_VALUE;
                while (reader.ready()) {
                    String str = reader.readLine();
                    String subString = str.substring(0, 8).trim();
                    int id = Integer.parseInt(subString);
                    if (id > maxId) maxId = id;
                }
                maxId++;
                writer.newLine();
                String result = String.format("%-8d%-30s%-8.2f%-4d", maxId, name, price, quantity);
                writer.write(result);
            }
        }
    }
}

//                int numberDigitsId = String.valueOf(id).length();
//                if (numberDigitsId == 8) {
//                    writer.write(id);
//                } else if (numberDigitsId < 8) {
//                    String spaces = null;
//                    for (int i = 8 - numberDigitsId; i > 0; i-- ) {
//                        spaces += " ";
//                    }
//                    writer.write(id + spaces);
//                }
//                if (name.length() == 30) {
//                    writer.write(name);
//                } else {
//                    StringBuilder spaces = null;
//                    for (int i = 30 - name.length(); i > 0; i--) {
//                        spaces.append(" ");
//                    }
//                    writer.write(name + spaces.toString());
//                }
//                int numberDigitsPrice = String.valueOf(price).length();
//                if (numberDigitsPrice == 8) {
//                    writer.write(String.valueOf(price));
//                } else {
//                    StringBuilder spaces = null;
//                    for (int i = 8 - numberDigitsPrice; i > 0; i--) {
//                        spaces.append(" ");
//                    }
//                    writer.write(String.valueOf(price) + spaces.toString());
//                }
//                int numberQuantity = String.valueOf(quantity).length();
//                if (numberQuantity == 4) {
//                    writer.write(quantity);
//                } else {
//                    StringBuilder spaces = null;
//                    for (int i = 4 - numberQuantity; i > 0; i--) {
//                        spaces.append(" ");
//                    }
//                    writer.write(quantity + spaces.toString());
//                }
//            }
//        }
//    }
//}
