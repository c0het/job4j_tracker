package ru.job4j.pojo;

public class Book {
    String nameOfBook;
    int numberOfPages;

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book(String nameOfBook, int numberOfPages) {
        this.nameOfBook = nameOfBook;
        this.numberOfPages = numberOfPages;

    }
}
