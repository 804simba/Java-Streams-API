package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

// https://www.youtube.com/watch?v=svQKKg3aFzo
interface Parser {
    String parse(String str);
}
class StringParser {
    public static String convert(String s) {
            return (s.length() <= 3) ? s.toUpperCase() : s.toLowerCase();
    }
}
class MyPrinter {
    public void print(String str, Parser p) {
        str = p.parse(str);
        System.out.println(str);
    }
}
public class MethodReference {
    public static void main(String[] args) {
        String name = "Timothy Olisaeloka";
        MyPrinter mp = new MyPrinter();

        // using method reference
        // simply put is that this convert function is the implementation of the
        // Parser interface. Thus, we are implementing the parser on the fly.
        mp.print(name, StringParser::convert);

        // passing values
//        mp.print(name, (str -> StringParser.convert(str)));

        // using anonymous class.
//        mp.print(name, new Parser() {
//            @Override
//            public String parse(String str) {
//                return StringParser.convert(str);
//            }
//        });
    }
}
