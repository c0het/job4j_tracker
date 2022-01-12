package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker tracker = null;

    private SingleTracker() {

    }

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }
}
