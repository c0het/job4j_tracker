package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ItemTest {

    @Test
    public void compareToItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Nikolai"),
                new Item("Semen")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Semen"),
                new Item("Nikolai"),
                new Item("Ivan")
        );
        assertEquals(items, expected);
    }

    @Test
    public void compareItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Nikolai"),
                new Item("Semen")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Ivan"),
                new Item("Nikolai"),
                new Item("Semen")
        );
        assertEquals(items, expected);
    }
}