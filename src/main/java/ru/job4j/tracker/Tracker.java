package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] item = new Item[items.length];
        int size = 0;
        for (int i = 0; i < item.length; i++) {
            if (items[i] != null) {
                item[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(item, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = findAll();
        int size = 0;
        for (int i = 0; i < rsl.length; i++) {
            String name = rsl[i].getName();
            if (key.equals(name)) {
                rsl[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}