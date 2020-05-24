package book;

public class Book {
    private String bookCode;
    private String name;
    private double price;
    private String author;

    protected Book() {
    }

    protected Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    protected Book(String bookCode, String name, double price, String author) {
        this.bookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "A book, There are code: " + bookCode + ", Name: " + name +
                ", Price: " + price + ", Author: " + author;
    }
}
