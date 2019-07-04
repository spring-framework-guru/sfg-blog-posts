package guru.springframework.xmlbasedbeandefinationinheritance.domain;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int bookPrice;

    public Book() {
    }

    public Book(String bookName, String bookAuthor, int bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String author) {
        this.bookAuthor = author;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int price) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + bookName + '\'' +
                ", author='" + bookAuthor + '\'' +
                ", price=" + bookPrice +
                '}';
    }
}
