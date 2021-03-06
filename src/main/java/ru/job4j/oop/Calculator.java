package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int y) {
        return minus(y) + divide(y) + sum(y) + multiply(y);
    }

    public int divide(int y) {
        return y / x;
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        System.out.println(Calculator.minus(10));
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(10));
        System.out.println(calculator.sumAllOperation(10));
    }
}
