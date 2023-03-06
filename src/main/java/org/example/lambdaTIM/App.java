package org.example.lambdaTIM;

import java.util.*;

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
        Employee john = new Employee("John", 30);
        Employee tim = new Employee("Tim", 20);
        Employee mary = new Employee("Mary", 50);
        Employee ruth = new Employee("Ruth", 40);
        List<Employee> employees = new ArrayList<>(Arrays.asList(john, tim, mary, ruth));
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        employees.sort(Comparator.comparing(Employee::getName));
        // There is always 3 parts to a Lambda expression:
        // parameters, arrow token and body.

//        Collections.sort(employees, (e1, e2) ->
//            e1.getName().compareTo(e2.getName()));
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(1).getName(), employees.get(2).getName());
//
//        System.out.println("Silly string: " + sillyString);
        // when you have multiple statements inside your lambda expression
        // add ";" after each statement.

        // we are assigning the implementation of the functional interface
        // to the Interface reference type uc;
        // if you have curly braces then the return keyword is required.
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//        String result = doStringStuff(uc, employees.get(1).getName(), employees.get(2).getName());
//        System.out.println(result);
        AnotherClass anotherClass = new AnotherClass();
        anotherClass.doSomething();
    }
    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}
interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}
class AnotherClass {
    /**
     * Local variables that are used outside the scope of an anonymous class have to be
     * declared as final, as they do not explicitly belong to that class
     * instance, thus when the anonymous class instance is created, a copy
     * of whatever value that variable is holding is what is being referred
     * by the anonymous class.
     * */
    public void doSomething() {
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class name is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        App.doStringStuff(uc, "Lagoon", "Hellcat");

//        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//        return App.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is :" + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "Pablo", "Huncho");
    }
}