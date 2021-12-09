package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String profiel;

    public Doctor(String name, String surname, String education, String birthday, String profiel) {
        super(name, surname, education, birthday);
        this.profiel = profiel;

    }

    public Diagnosis heal() {
        return null;
    }
}
