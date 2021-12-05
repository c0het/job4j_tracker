package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    private int x;

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point that) {
        return sqrt(pow(that.x - this.x, 2) + pow(that.y - this.y, 2));
    }

    public static void main(String[] args) {
        Point point = new Point(2, 5);
        Point point1 = new Point(4, 6);
        double dist = point.distance(point1);
        System.out.println(dist);

    }

}
