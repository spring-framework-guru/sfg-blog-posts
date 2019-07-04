package guru.springframework.annotationbasedbeandefinationinheritance.domain;

public class Book {
    private String bookName;
    private int bookPrice;
    private String authorName;

    public Book() {
    }

    public Book(String bookName, int bookPrice, String authorName) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
