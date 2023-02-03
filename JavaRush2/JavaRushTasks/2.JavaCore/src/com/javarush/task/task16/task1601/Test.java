package com.javarush.task.task16.task1601;

public class Test {
    public static volatile boolean ready = false;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.print(i + " ");
                    count++;
                }
                ready = true;
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ready);
                System.out.println("Finish" + count);
            }
        });
        thread2.start();

    }

}
