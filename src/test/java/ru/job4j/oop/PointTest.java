package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.oop.Point;

public class PointTest {

    @Test
    public void when00to20then2() {
        double expected = 2;
        Point point = new Point(0, 0);
        Point point1 = new Point(2, 0);
        double out = point.distance(point1);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when20to20then0() {
        double expected = 0;
        Point point = new Point(2, 0);
        Point point1 = new Point(2, 0);
        double out = point.distance(point1);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when22to20then2() {
        double expected = 2;
        Point point = new Point(2, 2);
        Point point1 = new Point(2, 0);
        double out = point.distance(point1);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when22to23then1() {
        double expected = 1;
        Point point = new Point(2, 2);
        Point point1 = new Point(2, 3);
        double out = point.distance(point1);
        Assert.assertEquals(expected, out, 0.01);
    }
}