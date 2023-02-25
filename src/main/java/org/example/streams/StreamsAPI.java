package org.example.streams;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7, 10);
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Does any element match the predicate? " + hasEven);
        System.out.println("------------------------------->");
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        evenNumbers.forEach(System.out::println);

        List<Integer> doubleNumbers = evenNumbers.stream()
                .map(n -> n * 2)
                .limit(4).toList();
        System.out.println("Doubled even numbers: " + doubleNumbers);

        System.out.println("------------------------------->");
        List<Integer> numbers2 = Arrays.asList(2, 4, 6, 3, 8, 10);
        List<Integer> onlyEvenNumbers = numbers2.stream()
                .takeWhile(n -> n % 2 == 0)
                .toList();
        System.out.println("Take while: " + onlyEvenNumbers);
        System.out.println("------------------------------->");

        System.out.print("Strings operation using Take while: ");
        List<String> words = Arrays.asList("apple", "banana", "carrot", "yam", "date", "eggplant");
        List<String> newWords = words.stream()
                .takeWhile(word -> word.length() > 3)
                .toList();
        System.out.println("New words: " + newWords);
        System.out.println("------------------------------->");
        List<Integer> myNumbers = Arrays.asList(1, 28, 39, 4, 100);
        int sumOfMyNumbers = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Reduced numbers: " + sumOfMyNumbers);

        // Sorted
        List<Employee> sortedEmployeesList = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println("Sorted Employees list: " + sortedEmployeesList);

        // Distinct
        List<Integer> integers = Arrays.asList(2, 5, 3, 2, 4, 3, 100, 20, 20, 50);
        List<Integer> distinctIntegers = integers.stream()
                .distinct()
                .sorted(Comparator.comparing(Integer::intValue)).toList();
        System.out.println("List of Distinct and Sorted integers: " + distinctIntegers);

        // Stream Specialization
        // IntStream
        int maxInt = integers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("max Integer: " + maxInt);

        // Advanced collect
        String employeeNames = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("names of employees: " + employeeNames);
    }
    private static final Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 10.0),
            new Employee(2, "Bill Gates", 30.8),
            new Employee(3, "Mark Zucks", 60.8),
            new Employee(3, "Harriet Tubman", 60.8),
            new Employee(3, "Abraham Lincoln", 60.8),
            new Employee(3, "Chris Rock", 60.8)
    };
    private static final List<Employee> employeeList = Arrays.asList(arrayOfEmps);
}
