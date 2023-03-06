package org.example.j8streams;
/*
 * A functional interface has only one abstract method.
 * Instances of functional interfaces can be created with
 * lambda expressions, method references or constructor references.
 *
 * the target type is the type of the functional interface implemented by the lambda expression.
 * https://stackoverflow.com/questions/55205665/what-is-meant-by-lambda-target-type-and-target-type-context-in-java
 * */

import java.util.*;
import java.util.function.IntPredicate;

class Data {
    private String name;

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
@FunctionalInterface
interface Lambda {
    void demo(int x, float y, double z);
}
@FunctionalInterface
interface Calculator {
    int sum(int x, int y);
}
public class App {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>(Arrays.asList(new Data("Tim Olisa"), new Data("Hannah"), new Data("Collins"), new Data("Ngozi Olisa")));
//        list.sort((Data d1, Data d2) -> d1.getName().compareTo(d2.getName()));
        list.sort(Comparator.comparing(Data::getName));

        list.sort((Data dataOne, Data dataTwo) -> {
            if (dataOne.getName().length() < dataTwo.getName().length()) {
                return -1;
            } else if (dataOne.getName().length() > dataTwo.getName().length()) {
                return 1;
            } else {
                return 0;
            }
        });
        for (Data data : list){
            System.out.println(data.getName());
        }
        Lambda lambda = (int x, float y, double z)-> {
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("z: " + z);
            System.out.println("lambda block ended.");
        };
        lambda.demo(2, 2.87f, 2.09);

        Calculator calculator = Integer::sum;
        int result = calculator.sum(2, 3);
        System.out.println(result);

        IntPredicate lessThan18 = i -> i < 18;
        IntPredicate olderThan10 = i -> i > 10;

        demo(14, lessThan18, olderThan10);
    }
    static void demo(int x, IntPredicate lessThan18, IntPredicate olderThan18) {
        if (lessThan18.and(olderThan18).test(x)) {
            System.out.println("The input is less than 18 and greater than 10");
        } else {
            System.out.println("Invalid input...");
        }
    }
}
