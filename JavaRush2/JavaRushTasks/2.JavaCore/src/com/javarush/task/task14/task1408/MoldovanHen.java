package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 30;
    }

    String getDescription() {
        StringBuilder str = new StringBuilder(super.getDescription() + " " + "Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
        String result = str.toString();
        return result;
    }
}
