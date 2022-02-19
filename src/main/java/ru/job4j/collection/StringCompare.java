package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.toCharArray().length; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl == 0 && left.toCharArray().length == i + 1) {
                rsl = Integer.compare(left.toCharArray().length, right.toCharArray().length);
                return rsl;
            } else if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}