package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat formatterRead = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat formatterOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, NumberFormatException {
        if (args == null || args.length < 1) {
            return;
        }

        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    int i = 1; //name
                    int j = 2; //sex
                    int g = 3; //bd
                    while (i < args.length && j < args.length && g < args.length) {
                        Person person = null;
                        switch (args[j]) {
                            case "м" :
                                person = Person.createMale(args[i], formatterRead.parse(args[g]));
                                break;
                            case "ж" :
                                person = Person.createFemale(args[i], formatterRead.parse(args[g]));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                        i += 3;
                        j += 3;
                        g += 3;
                    }
                    break;
                }
            case "-u" :
                synchronized (allPeople) {
                    int i = 1; //id
                    int j = 2; //name
                    int g = 3; //sex
                    int h = 4; //bd
                    while (i < args.length && j < args.length && g < args.length && h < args.length) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));//добавить проверку на int
                        person.setName(args[j]);
                        person.setSex(args[g].equals("м") ? Sex.MALE : Sex.FEMALE );
                        person.setBirthDate(formatterRead.parse(args[h]));
                        i += 4;
                        j += 4;
                        g += 4;
                        h += 4;
                    }
                    break;
                }
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
                }
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + ((person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + formatterOut.format(person.getBirthDate())));
                    }
                }
                break;
        }
    }
}
