package ru.job4j.tracker;

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
        int amountDeleteItems = input.askInt("Enter the amount to delete items: ");
        int[] idDelete = new int[amountDeleteItems];
        for (int i = 0; i < amountDeleteItems; i++) {
            idDelete[i] = input.askInt("Enter id: ");
        }
        for (int i = 0; i < amountDeleteItems; i++) {
            if (store.delete(idDelete[i])) {
                output.println("Заявка " + idDelete[i] +" удалена успешно");
            } else {
                output.println("Ошибка удаления заявки " + idDelete[i]);
            }
        }
        return true;
    }
}
