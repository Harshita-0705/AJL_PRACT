class Pizza {

    String base;
    String topping;

    void showPizza() {
        System.out.println("Base: " + base);
        System.out.println("Topping: " + topping);
    }
}

class PizzaBuilder {

    Pizza pizza = new Pizza();

    void buildBase() {
        pizza.base = "Thin Crust";
    }

    void buildTopping() {
        pizza.topping = "Cheese";
    }

    Pizza getPizza() {
        return pizza;
    }
}

public class BuilderDemo {

    public static void main(String[] args) {

        PizzaBuilder builder = new PizzaBuilder();

        builder.buildBase();
        builder.buildTopping();

        Pizza p = builder.getPizza();

        p.showPizza();
    }
}