package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
TOP
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
            if (args[0].equals("-c")) {
                Person person = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                String strDate = args[3];
                Date date = formatter.parse(strDate);
                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], date);
                    allPeople.add(person);
                } else if (args[2].equals("ж")) {
                    person = Person.createFemale(args[1], date);
                    allPeople.add(person);
                }
                System.out.println(allPeople.indexOf(person));

            } else if (args[0].equals("-r")) {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String date = formatter.format(person.getBirthDate());
                String sex = null;
                if (person.getSex().equals(Sex.MALE)) {
                    sex = "м";
                } else if (person.getSex().equals(Sex.FEMALE)) {
                    sex = "ж";
                }
                System.out.println(person.getName() + " " + sex + " " + date );
            } else if (args[0].equals("-u")) {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                person.setName(args[2]);
                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equals("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = formatter.parse(args[4]);
                person.setBirthDate(date);
                allPeople.set(id, person);
            } else if (args[0].equals("-d")) {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                person.setBirthDate(null);
                person.setSex(null);
                person.setName(null);
                allPeople.set(id, person);
            }
        }
}
