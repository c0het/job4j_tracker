package ru.job4j.tracker;

public final class SingleTracker {
    private static MemTracker memTracker = null;

    private SingleTracker() {

    }

    public static MemTracker getTracker() {
        if (memTracker == null) {
            memTracker = new MemTracker();
        }
        return memTracker;
    }
}
