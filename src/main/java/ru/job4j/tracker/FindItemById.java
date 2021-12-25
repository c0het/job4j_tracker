package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private final Output output;

    public FindItemById(Output output) {
        this.output =  output;
    }

    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Заявка с веденным id: " + id + "не найдена");
        }
        return true;
    }
}
