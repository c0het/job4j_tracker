package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output output;

    public DeleteItem(Output output) {
        this.output =  output;
    }

    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        output.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (store.delete(id)) {
            output.println("Заявка удалена успешно.");
        } else {
            output.println("Ошибка удаления заявка.");
        }
        return true;
    }
}
