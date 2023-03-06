package org.example.lambdaTIM2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
        AnotherClass anotherClass = new AnotherClass();
        anotherClass.doSomething();
        Employee john = new Employee("John", 30);
        Employee tim = new Employee("Tim", 20);
        Employee mary = new Employee("Mary", 50);
        Employee ruth = new Employee("Ruth", 40);
        List<Employee> employees = new ArrayList<>(Arrays.asList(john, tim, mary, ruth));

//        employees.forEach(employee -> {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });
        Predicate<Integer> predicate = x -> (x > 20);
        System.out.println("Result: " + predicate.test(100));
    }
    public static String doSomething(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1.toUpperCase(), s2.toUpperCase());
    }
}
interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}
class AnotherClass {
    String doSomething() {
        final int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return App.doSomething(uc, "Nonso Okongwu", "Ayra Starr");
    }
    public void printValue() {
        int number = 25;
        Runnable r = () -> {
          try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
    }
}
