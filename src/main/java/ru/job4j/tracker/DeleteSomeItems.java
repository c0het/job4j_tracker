package ru.job4j.tracker;

import java.util.List;

public class DeleteSomeItems implements UserAction{
    private final Output output;

    public DeleteSomeItems(Output output) {
        this.output =  output;
    }


    @Override
    public String name() {
        return "Delete some items.";
    }

    @Override
    public boolean execute(Input input, Store store) {
        output.println("=== Delete some items ===");
        List<Item> items = store.findAll();
        for (Item item : items) {
            store.delete(item.getId());
        }
        return true;
    }
}
