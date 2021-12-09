package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String status;

    public Builder(String name, String surname, String education, String birthday, String profiel, String status) {
        super(name, surname, education, birthday, profiel);
        this.status = status;
    }

    public Design status() {
        return null;
    }
}
