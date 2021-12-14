package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
    Item item = new Item();
    LocalDateTime created = item.getCreated();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    String timeAndDate = created.format(formatter);
    System.out.println(timeAndDate);
    Item item1 = new Item(5, "Client");
    System.out.println(item1);
    }
}
