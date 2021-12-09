package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int sickTeeth;

    public Dentist(String name, String surname, String education, String birthday, String profiel, int sickTeeth) {
        super(name, surname, education, birthday, profiel);
        this.sickTeeth = sickTeeth;
    }

    public DelTooth tooth(int sickTeeth) {
        return null;
    }
}

