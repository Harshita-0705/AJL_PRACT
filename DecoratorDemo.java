interface Coffee {
    int cost();
    String description();
}
class SimpleCoffee implements Coffee {

    public int cost() {
        return 50;
    }

    public String description() {
        return "Simple Coffee";
    }
}
abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
class MilkDecorator extends CoffeeDecorator {

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 10;
    }

    public String description() {
        return coffee.description() + " + Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 5;
    }

    public String description() {
        return coffee.description() + " + Sugar";
    }
}
public class Main {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " = " + coffee.cost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.description() + " = " + coffee.cost());
    }
}