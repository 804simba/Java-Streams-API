package functionpkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * A consumer represents an operation that accepts a single input argument
 * and returns no result. It is a function with one argument that returns a
 * void.
 *
 * A Predicate represents a statement that determines whether a value could be
 * true or false. It is a function with one argument that return a boolean value.
 * */
class Employee {
    private String name;
    private int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
public class App {
    public static void main(String[] args) {
        Employee john = new Employee("John Snow", 30);
        Employee tim = new Employee("Tim Cook", 21);
        Employee mary = new Employee("Mary Slessor", 40);
        Employee ruth = new Employee("Ruth Akpai", 22);
        Employee sarah = new Employee("Sarah Akpai", 35);
        Employee joe = new Employee("Joe Akpai", 31);
        List<Employee> employees = new ArrayList<>(Arrays.asList(john, tim, mary, ruth, sarah, joe));
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);
    }
    private static void printEmployeesByAge(List<Employee> employees
    , String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        String x = "*".repeat(10) + "#".repeat(10) + "*".repeat(10);
        System.out.println(x);
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
//        employees.forEach(employee -> {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
    }
}
