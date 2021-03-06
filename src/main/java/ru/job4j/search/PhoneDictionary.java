package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

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
        Predicate<Person> combineAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combineSurName = x -> x.getSurname().contains(key);
        Predicate<Person> combineName = x -> x.getName().contains(key);
        Predicate<Person> combinePhone = x -> x.getPhone().contains(key);
        Predicate<Person> combine = combineName.or(combineAddress.or(combineSurName.or(combinePhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}


