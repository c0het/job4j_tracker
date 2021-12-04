package ru.job4j.oop;

public class Erorr {
    private boolean active;
    private int status;
    private String message;

    public Erorr() {
    }

    public Erorr(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void print() {
        System.out.print(active + "; ");
        System.out.print(status + "; ");
        System.out.print(message + "; ");
        System.out.println();
    }

    public static void main(String[] args) {
        Erorr erorr1 = new Erorr();
        Erorr erorr2 = new Erorr(true, 401, "restart");
        Erorr erorr3 = new Erorr(false, 98, "clean memory");
        erorr1.print();
        erorr2.print();
        erorr3.print();
    }
}
