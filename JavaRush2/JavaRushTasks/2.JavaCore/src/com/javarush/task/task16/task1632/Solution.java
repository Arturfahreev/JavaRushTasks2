package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread thread1 = new Thread( () -> { while(true) {} } );

        Thread thread2 = new Thread( () -> { try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } } );

        Thread thread3 = new Thread( () -> { while (true) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } } );

        Thread4 thread4 = new Thread4();

        Thread thread5 = new Thread( () -> {
            int sum = 0;
            Scanner sc = new Scanner(System.in);
            String str;
            while (!(str = sc.nextLine()).equals("N")) {
                sum += Integer.parseInt(str);
            }
            System.out.println(sum);
        });

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void showWarning() {
            if (this.isAlive()) {
                this.interrupt();
            }

        }

        @Override
        public void run() {
            try {
                while (!(this.isInterrupted())) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {

            }

        }
    }
}