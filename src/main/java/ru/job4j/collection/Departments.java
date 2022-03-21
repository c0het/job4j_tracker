package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> setRsl = new LinkedHashSet<>();
        for (String value : deps) {
            String start = null;
            for (String el : value.split("/")) {
                if (start == null) {
                setRsl.add(el);
                start = el;
                } else {
                    setRsl.add(start + "/" + el);
                }
            }
        }
        return new ArrayList<>(setRsl);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}