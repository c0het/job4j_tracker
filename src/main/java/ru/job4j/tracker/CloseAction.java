package ru.job4j.tracker;

public class CloseAction implements UserAction {
    private final Output output;

    public CloseAction(Output  output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
