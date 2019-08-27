package guru.springframework.springbeanlifecycle.beanpostprocessor.domain;

public class BookBean {
    private String bookName;

    public BookBean() {
        System.out.println("Constructor of BookBean called !! ");

    }

    public BookBean(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
