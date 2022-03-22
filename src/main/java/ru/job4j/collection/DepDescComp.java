package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String one = o1.split("/")[0];
        String two = o2.split("/")[0];
        int rsl = two.compareTo(one);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}
