package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int sickTeeth;

    public Dentist(String name, String surname, String education, String birthday, int sickTeeth) {
        super(name, surname, education, birthday);
        this.sickTeeth = sickTeeth;
    }

    public DelTooth tooth(int sickTeeth) {
        return null;
    }
}

