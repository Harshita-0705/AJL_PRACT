class Book {

    String name;

    Book(String name) {
        this.name = name;
    }

    void show() {
        System.out.println(name);
    }
}

class BookFactory {

    static Book book = new Book("Java Book");

    static Book getBook() {
        return book;
    }
}

public class FlyweightDemo {

    public static void main(String[] args) {

        Book b1 = BookFactory.getBook();
        b1.show();

    }
}