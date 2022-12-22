package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class CreateSomeItems implements UserAction{

    private final Output output;

    public CreateSomeItems(Output output) {
        this.output =  output;
    }


    @Override
    public String name() {
        return "Add some new items.";
    }

    @Override
    public boolean execute(Input input, Store store) {
        output.println("=== Create some new Items ===");
        int amountItems = input.askInt("Enter amount items: ");
        List<Item> items = new ArrayList<>();
        String name = "name";
        for (int i = 0; i < amountItems; i++) {
            items.add(new Item(name + i));
        }
        return true;
    }
}
