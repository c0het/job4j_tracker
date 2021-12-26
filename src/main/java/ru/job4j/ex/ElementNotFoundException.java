package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            } else {
                throw new ElementNotFoundException();
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"car", "dog", "cat"};
        String key = "bus";
        try {
            indexOf(value, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
