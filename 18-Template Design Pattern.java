// The Template Design Pattern is a behavioral pattern that defines the skeleton of an algorithm in a superclass and allows subclasses to override specific steps without changing the overall algorithm structure.
// Common steps stay fixed, variable steps are customized.
// Example:
// Preparing different beverages (Tea / Coffee) using the same steps.

abstract class Beverage {

    // Template method
    final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void brew();
    abstract void addCondiments();
}

class Tea extends Beverage {
    void brew() {
        System.out.println("Brewing tea leaves");
    }

    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends Beverage {
    void brew() {
        System.out.println("Brewing coffee beans");
    }

    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareBeverage();

        System.out.println();

        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
    }
}