import java.util.ArrayList;
import java.util.List;

// Component
interface Employee {
    void showDetails();
}

// Leaf
class Developer implements Employee {

    String name;

    Developer(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}

// Composite
class Manager implements Employee {

    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void showDetails() {

        System.out.println("Manager Team:");

        for(Employee e : employees) {
            e.showDetails();
        }
    }
}

// Main Class
public class CompositeDemo {

    public static void main(String[] args) {

        Developer d1 = new Developer("Rahul");
        Developer d2 = new Developer("Priya");

        Manager manager = new Manager();

        manager.addEmployee(d1);
        manager.addEmployee(d2);

        manager.showDetails();
    }
}