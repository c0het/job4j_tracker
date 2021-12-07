package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String profiel;

    public Engineer(String name, String surname, String education, String birthday, String profile) {
        super(name, surname, education, birthday);
        this.profiel = profile;
    }

    public Construction build() {
        return null;
    }
}
