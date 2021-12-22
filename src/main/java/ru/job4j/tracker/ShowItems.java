package ru.job4j.tracker;

public class ShowItems implements UserAction {
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("===Show all items===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items)  {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище не содержит заявок");
        }
        return true;
    }
}
