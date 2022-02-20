package ru.job4j.collection;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int numberLeft = 0;
        int numberRight = 0;
        for (int i = 0; i < Math.min(left.split("\\. ").length, right.split("\\. ").length); i++) {
            try {
                numberLeft = Integer.parseInt(left.split("\\. ")[i]);
                numberRight = Integer.parseInt(right.split("\\. ")[i]);
               break;
            } catch (NumberFormatException e) {
                System.out.println("В строке нету чисел");
            }

        }
        return Integer.compare(numberLeft, numberRight);
    }
}