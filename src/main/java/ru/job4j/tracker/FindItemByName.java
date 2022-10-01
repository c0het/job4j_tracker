package ru.job4j.tracker;

import java.util.List;

public class FindItemByName implements UserAction {
    private final Output output;

    public FindItemByName(Output output) {
        this.output =  output;
    }

    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        output.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = store.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем:" + name + " не найдены.");
        }
        return true;
    }
}
