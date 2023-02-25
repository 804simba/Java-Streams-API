package org.example;

import java.util.stream.Collectors;

/*
* The chars() method is used to get a stream of integer values that represent the characters of the string.
* The distinct() method is used to get a stream of distinct integer value.
* The mapToObj() is used to convert each integer value to a string representation of the corresponding character.
* Finally, the collect() is used to collect all the strings into a single string using the joining() method of the
* Collectors class.
* */
public class Main {
    public static void main(String[] args) {
        String word = "Timothy Ngonadi";
        String distinctLetters = word.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.joining());
        System.out.println("Distinct words: " + distinctLetters);


    }
}