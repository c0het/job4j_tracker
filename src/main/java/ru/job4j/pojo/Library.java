package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 10);
        Book book2 = new Book("Rain", 555);
        Book book3 = new Book("Fly", 324);
        Book book4 = new Book("Thief", 654);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book book =  books[index];
            System.out.println("Название книги - " + book.getNameOfBook() + ", страниц в книге - " + book.getNumberOfPages());
        }
        System.out.println("Replace 0 to 3");
        books[3] = books[0];
        books[0] = book4;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Название книги - " + book.getNameOfBook() + ", страниц в книге - " + book.getNumberOfPages());
        }
        System.out.println("Only \"Clean code\"");
        for (int inedex = 0; inedex < books.length; inedex++) {
            Book book = books[inedex];
            if ("Clean code".equals(book.getNameOfBook())) {
                System.out.println("Название книги - " + book.getNameOfBook() + ", страниц в книге - " + book.getNumberOfPages());
            }
        }
    }
}
