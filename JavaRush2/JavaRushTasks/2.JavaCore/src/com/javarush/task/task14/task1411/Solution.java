package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, "loser", "coder", "proger", "user");

        while (strings.contains(key = reader.readLine()))
        {
            if (key.equals("user")) {
                person = new Person.User();
            }

            if (key.equals("loser")) {
                person = new Person.Loser();
            }

            if (key.equals("coder")) {
                person = new Person.Coder();
            }

            if (key.equals("proger")) {
                person = new Person.Proger();
            }

            doWork(person);
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
