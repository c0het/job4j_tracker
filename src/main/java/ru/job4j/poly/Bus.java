package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Длина маршрута 20 км.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Автобус вмещает " + number + "пасажиров");
    }

    @Override
    public double price(int numberFuel) {
        double pricePerLiter = 45.50;
        return (numberFuel * pricePerLiter);
    }
}
