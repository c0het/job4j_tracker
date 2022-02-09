package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            String name = person.getName();
            String surname = person.getSurname();
            String phone = person.getPhone();
            String address = person.getAddress();
            if (name.contains(key) || surname.contains(key) || phone.contains(key) || address.contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}


