import java.util.*;
import java.util.stream.Collectors;

record Employee(String name, String department,
                double salary, int yearJoined) {}

public class EmployeeReportGenerator {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
            new Employee("Alice", "Engineering", 95000, 2018),
            new Employee("Bob", "Marketing", 60000, 2021),
            new Employee("Carol", "Engineering", 112000, 2020),
            new Employee("Dave", "HR", 52000, 2019),
            new Employee("Eve", "Marketing", 78000, 2022),
            new Employee("Frank", "Engineering", 88000, 2021)
        );

        // 1. Average salary per department
        System.out.println("Average Salary Per Department:");
        System.out.println(
            list.stream()
                .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.averagingDouble(Employee::salary)
                ))
        );

        // 2. Highest paid employee in each department
        System.out.println("\nHighest Paid Employee Per Department:");
        System.out.println(
            list.stream()
                .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.collectingAndThen(
                        Collectors.maxBy(
                            Comparator.comparingDouble(Employee::salary)
                        ),
                        Optional::get
                    )
                ))
        );

        // 3. Names joined after 2019
        System.out.println("\nEmployees Joined After 2019:");
        System.out.println(
            list.stream()
                .filter(e -> e.yearJoined() > 2019)
                .map(Employee::name)
                .sorted()
                .collect(Collectors.joining(", "))
        );
    }
}