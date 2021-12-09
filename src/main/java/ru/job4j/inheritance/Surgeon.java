package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int successfulOperations;

    public Surgeon(String name, String surname, String education, String birthday,
                   String profiel, int successfulOperations) {
        super(name, surname, education, birthday, profiel);
        this.successfulOperations = successfulOperations;
    }

    public ResOperation reslut() {
        return null;
    }

}
