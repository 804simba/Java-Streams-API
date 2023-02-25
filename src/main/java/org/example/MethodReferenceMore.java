package org.example;

public class MethodReferenceMore {
    interface Parser {
        String parse(String s);
    }

    class StringConverter {
        public static String convert(String s) {
            return s + " is a Boss!";
        }
    }

    public static void main(String[] args) {
        // we are assigning the implementation of Parser interface parse method to p.
        Parser p = StringConverter::convert;
        System.out.println("Parsed string: " + p.parse("Timothy Olisaeloka"));
    }
}
