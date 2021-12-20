package ru.job4j.oop;

public class Moving {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{airplane, bus, train};
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}

