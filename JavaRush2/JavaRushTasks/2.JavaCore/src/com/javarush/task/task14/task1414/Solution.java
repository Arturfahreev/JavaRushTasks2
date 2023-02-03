package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, "cartoon", "thriller", "soapOpera");
        String key = null;
        Movie movie = null;

        while (strings.contains(key = reader.readLine())) {
             movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
        }
        movie = MovieFactory.getMovie(key);


        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }

}
