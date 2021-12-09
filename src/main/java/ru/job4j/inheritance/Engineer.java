package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String profiel;

    public Engineer(String name, String surname, String education, String birthday, String profiel) {
        super(name, surname, education, birthday);
        this.profiel = profiel;
    }

    public Construction build() {
        return null;
    }
}
