package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void stringToComp() {
        StringCompare compare = new StringCompare();
        int exp = compare.compare("Cat", "Dog");
        int strCom = "Cat".compareTo("Dog");
        assertEquals(exp, strCom);
    }

    @Test
    public void stringToComp1() {
        StringCompare compare = new StringCompare();
        int exp = compare.compare("Cat", "Dogs");
        int strCom = "Cat".compareTo("Dogs");
        assertEquals(exp, strCom);

    }

    @Test
    public void stringToComp2() {
        StringCompare compare = new StringCompare();
        int exp = compare.compare("Cats", "Dog");
        int strCom = "Cats".compareTo("Dog");
        assertEquals(exp, strCom);

    }
}