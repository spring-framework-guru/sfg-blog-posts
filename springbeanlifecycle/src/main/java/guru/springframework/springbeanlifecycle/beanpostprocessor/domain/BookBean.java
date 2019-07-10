package guru.springframework.springbeanlifecycle.beanpostprocessor.domain;

public class BookBean {
    private String bookName;

    public BookBean() {
        System.out.println("Constructor of BookBean is called !! ");

    }

    public void init() throws Exception {
        System.out.println("custom custom init method of BookBean is called !! ");
    }
    public void destroy() throws Exception {
        System.out.println(" custom destroy  method of BookBean is called !! ");
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
