// The Visitor Design Pattern is a behavioral pattern that lets you add new operations to a class structure without modifying the classes themselves.
// Behavior is separated from the object structure.
// Example:
// Performing different operations (Tax, Discount) on items in a Shopping Cart.

interface Item {
    void accept(Visitor visitor);
}

class Book implements Item {
    double price = 500;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Pen implements Item {
    double price = 50;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Book book);
    void visit(Pen pen);
}

class TaxVisitor implements Visitor {

    public void visit(Book book) {
        double tax = book.price * 0.10;   // 10% tax
        System.out.println("Book final price: " + (book.price + tax));
    }

    public void visit(Pen pen) {
        double tax = pen.price * 0.05;    // 5% tax
        System.out.println("Pen final price: " + (pen.price + tax));
    }
}

public class VisitorPatternDemo {
    public static void main(String[] args) {

        Item book = new Book();
        Item pen = new Pen();

        Visitor taxVisitor = new TaxVisitor();

        book.accept(taxVisitor);
        pen.accept(taxVisitor);
    }
}