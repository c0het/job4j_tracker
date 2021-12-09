package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education, String birthday, String profiel, String language) {
        super(name, surname, education, surname, profiel);
        this.language = language;
    }

    public Profile profile() {
        return null;
    }

}
