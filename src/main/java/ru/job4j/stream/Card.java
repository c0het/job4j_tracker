package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Suit[] suits = {Suit.Clubs, Suit.Diamonds, Suit.Spades, Suit.Hearts};
        Stream.of(values)
                .flatMap(value -> Stream.of(suits)
                        .map(suit1 -> new Card(suit1, value)))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{"
                + "Масть = " + suit
                + ", Значение = " + value
                + '}';
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }
}

