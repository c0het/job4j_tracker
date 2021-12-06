package ru.job4j.oop;

public class Max {

    public static int max(int left, int right) {
        boolean comp = left > right;
        int result = comp ? left : right;
        return result;
    }

    public static int max(int num1, int num2, int num3) {
        return max(num1, max(num2, num3));
    }

    public static int max(int num1, int num2, int num3, int num4) {
        return max(num1, max(num2, num3, num4));
    }
}


