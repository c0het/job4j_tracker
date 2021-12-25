package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    private final Output output;

    public FindItemByName(Output output) {
        this.output =  output;
    }

    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем:" + name + " не найдены.");
        }
        return true;
    }
}
