package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 40;
    }

    String getDescription() {
        StringBuilder str = new StringBuilder(super.getDescription() + " " + "Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
        String result = str.toString();
        return result;
    }
}
