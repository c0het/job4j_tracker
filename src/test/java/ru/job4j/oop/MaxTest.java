package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class MaxTest extends TestCase {

    public void testMax() {
        int rsl = Max.max(4, 6);
        int exception = 6;
        Assert.assertEquals(exception, rsl);
    }

    public void testTestMax() {
        int rsl = Max.max(6, 7, 10);
        int exception = 10;
        Assert.assertEquals(exception, rsl);
    }

    public void testTestMax1() {
        int rsl = Max.max(4, 6, 20, 10);
        int exception = 20;
        Assert.assertEquals(exception, rsl);
    }
}