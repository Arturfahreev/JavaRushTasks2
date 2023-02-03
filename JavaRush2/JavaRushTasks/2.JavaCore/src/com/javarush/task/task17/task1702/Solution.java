package com.javarush.task.task17.task1702;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* 
Вместе быстрее? Ща проверим :)
*/

public class Solution {
    public static int threadCount = 10;
    public static int size = 30_000;
    public static AtomicIntegerArray testArray = new AtomicIntegerArray(size);

    static {
        for (int i = 0; i < Solution.testArray.length(); i++) {
            testArray.set(i, i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startSystemMillis = System.currentTimeMillis();
        long startSystemNano = System.nanoTime();
        Instant startInstant = Instant.now();

        StringBuffer expectedResult = new StringBuffer();
        for (int i = size - 1; i >= 0; i--) {
            expectedResult.append(i).append(" ");
        }

        initThreads();
        //sort(testArray);

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < testArray.length(); i++) {
            result.append(testArray.get(i)).append(" ");
        }
        //System.out.println(result);
        System.out.println((result.toString()).equals(expectedResult.toString()));

        long endMillis = System.currentTimeMillis();
        long endNano = System.nanoTime();
        Instant endInstant = Instant.now();
        long resultMillis = endMillis - startSystemMillis;
        long resultNano = endNano - startSystemNano;
        long resultInstantMillis = Duration.between(startInstant, endInstant).toMillis();
        long resultInstantNano = Duration.between(startInstant, endInstant).toNanos();
        System.out.println("time millis " + resultMillis);
        System.out.println("time nano " + resultNano / 1_000_000);
        System.out.println("time Instant millis " + resultInstantMillis);
        System.out.println("time Instant nano " + resultInstantNano / 1_000_000);
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(threadCount);
        for (int i = 0; i < threadCount; i++) threads.add(new SortThread());
        for (Thread thread : threads) {
            thread.start();
        }
       for (Thread thread : threads) thread.join();
    }

    public static synchronized void sort(AtomicIntegerArray array) {
        for (int i = 0; i < array.length() - 1; i++) {
            for (int j = i + 1; j < array.length(); j++) {
                if (array.get(i) < array.get(j)) {
                    int k = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, k);
                }
            }
        }
    }
    public static class SortThread extends Thread {
        public void run () {
                sort(testArray);
        }
    }
}

