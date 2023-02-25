package org.example.streams;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7, 10);
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        evenNumbers.forEach(System.out::println);

        List<Integer> numbers2 = Arrays.asList(2, 4, 6, 3, 8, 10);
        List<Integer> onlyEvenNumbers = numbers2.stream()
                .takeWhile(n -> n % 2 == 0)
                .toList();
        System.out.println("Take while: " + onlyEvenNumbers);

        System.out.print("Strings operation using Take while: ");
        List<String> words = Arrays.asList("apple", "banana", "carrot", "yam", "date", "eggplant");
        List<String> newWords = words.stream()
                .takeWhile(word -> word.length() > 3)
                .toList();
        System.out.println("New words: " + newWords);
    }
    private static final Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 10.0),
            new Employee(2, "Bill Gates", 30.8),
            new Employee(3, "Mark Zucks", 60.8)
    };
    private static final List<Employee> employeeList = Arrays.asList(arrayOfEmps);
}
