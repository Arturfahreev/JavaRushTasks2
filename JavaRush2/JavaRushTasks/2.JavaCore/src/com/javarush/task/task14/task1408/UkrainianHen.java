package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    String getDescription() {
        StringBuilder str = new StringBuilder(super.getDescription() + " " + "Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
        String result = str.toString();
        return result;
    }

}
