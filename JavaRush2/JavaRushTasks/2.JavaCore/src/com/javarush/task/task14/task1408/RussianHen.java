package com.javarush.task.task14.task1408;

import java.sql.SQLOutput;

class RussianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    String getDescription() {
        StringBuilder str = new StringBuilder(super.getDescription() + " " + "Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
        String result = str.toString();
        return result;
    }
}
