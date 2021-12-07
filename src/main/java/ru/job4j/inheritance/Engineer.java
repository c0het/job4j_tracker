package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String profiel;

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Construction build() {
        return null;
    }
}
