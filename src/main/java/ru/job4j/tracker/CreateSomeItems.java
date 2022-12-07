package ru.job4j.tracker;

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
        Item[] items = new Item[amountItems];
        String name;
        for (int i = 0; i < amountItems; i++) {
            name = input.askStr("Enter name: ");
            items[i] = new Item(name);
        }
        for (int i = 0; i < amountItems; i++) {
            store.add(items[i]);
            output.println("Добавленная заявка " + items[i]);
        }
        return true;
    }
}
