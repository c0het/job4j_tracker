package ru.job4j.tracker;

import java.util.List;

public class ShowItems implements UserAction {
    private final Output output;

    public ShowItems(Output output) {
        this.output =  output;
    }

    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store store) {
        output.println("===Show all items===");
        List<Item> items = store.findAll();
        if (items.size() > 0)  {
            for (Item item : items)  {
                output.println(item);
            }
        } else {
            output.println("Хранилище не содержит заявок");
        }
        return true;
    }
}
