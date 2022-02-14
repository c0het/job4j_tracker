package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        int clone = 0;
        int notClone = 0;
        for (String s : text) {
            if (check.contains(s)) {
                clone++;
            } else {
                notClone++;
            }
            rsl = clone >= notClone;
        }
        return rsl;
    }
}