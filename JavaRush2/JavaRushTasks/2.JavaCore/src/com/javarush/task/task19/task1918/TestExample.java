package com.javarush.task.task19.task1918;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestExample {
    public static void main(String[] args) {
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .filter(x -> x > 0)
                //.distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));

    }
}
