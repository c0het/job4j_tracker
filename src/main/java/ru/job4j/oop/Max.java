package ru.job4j.oop;

public class Max {

    public static int max(int left, int right) {
        boolean comp = left > right;
        int result = comp ? left : right;
        return result;
    }

    public static int max(int num1, int num2, int num3) {
        int max = Math.max(num1, num2);
        max = Math.max(max, num3);
        return max;
    }

    public static int max(int num1, int num2, int num3, int num4) {
        int max = Math.max(num1, num2);
        max = Math.max(max, num3);
        max = Math.max(max, num4);
        return max;
    }
}


