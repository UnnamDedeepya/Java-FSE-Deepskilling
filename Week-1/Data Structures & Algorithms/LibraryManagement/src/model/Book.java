package model;

public class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "[ID: " + bookId + ", Title: " + title + ", Author: " + author + "]";
    }
}
