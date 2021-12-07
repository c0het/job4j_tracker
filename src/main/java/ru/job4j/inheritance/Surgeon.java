package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int successfulOperations;

    public Surgeon(String name, String surname, String education, String birthday, int successfulOperations) {
        super(name, surname, education, birthday);
        this.successfulOperations = successfulOperations;
    }

    public ResOperation reslut() {
        return null;
    }

}
