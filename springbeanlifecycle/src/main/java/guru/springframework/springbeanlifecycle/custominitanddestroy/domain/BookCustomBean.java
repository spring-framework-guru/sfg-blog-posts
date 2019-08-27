package guru.springframework.springbeanlifecycle.custominitanddestroy.domain;

public class BookCustomBean {
    private String bookName;

    public BookCustomBean() {
        System.out.println("Constructor of BookCustomBean bean is called !! ");
    }

    public void customDestroy() throws Exception {

        System.out.println("Custom destroy method of BookCustomBean called !! ");
    }

    public void customInit() throws Exception {
        System.out.println("Custom Init  method of BookCustomBean called !! ");
    }

    public BookCustomBean(String bookName) {
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
        return "Book{" +
                "bookName='" + bookName + '\'' +
                '}';
    }

}
