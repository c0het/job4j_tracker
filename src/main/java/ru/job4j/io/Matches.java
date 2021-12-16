package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (matches > 3) {
                System.out.println("Так нельзя! Нужно взять от 1ой до 3ех спичкек!!!");
                matches = Integer.parseInt(input.nextLine());
            }
            if (count - matches > 0) {
                count -= matches;
            } else if (count - matches < 0) {
                System.out.println("Осталось меньше спичек, чем вы хотите взять");
                matches = Integer.parseInt(input.nextLine());
            }
        count  -= matches;
        System.out.println("Осталось " + count + " спичек");
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}