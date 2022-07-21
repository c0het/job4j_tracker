package ru.job4j.map;

public record Label(String name, double score) implements Comparable<Label> {

    @Override
    public int compareTo(Label o) {
        return Double.compare(o.score, this.score);
    }
}