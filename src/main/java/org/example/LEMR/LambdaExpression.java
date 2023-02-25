package org.example.LEMR;

public class LambdaExpression {
    public static void main(String[] args) {
//        Cat cat = new Cat();
//        printThing(cat);
        // Cat is a Printable object thus the print()
        // method implemented in Cat is invoked.

        // Lambda expression;
        // It allowed us to pass the implementation of
        // the print() method that we need as a parameter.
        // No need to declare the type of the parameter as JVM infers it automatically.
        Printable lambdaPrintable = (p, s) -> {
            System.out.println(p + "Meow" + s);
            return "Meow";
        };

        // if you want to return a value without printing to the console.
        Printable lambdaPrintable2 = (p, s) -> "Meow" + s;
        String res = printThing(lambdaPrintable2);
        System.out.println("Returned valued from Lambda Expression: " + res);
    }

    static class Cat implements Printable{
        public Cat() {
        }

        @Override
        public String print(String prefix, String suffix) {
//            System.out.println("Meow");
            return "meow";
        }
    }

    /* this is a functional interface
    * It is an interface which contains only one abstract method.
    * However, they can contain any quantity of default and static methods.
    * */
    @FunctionalInterface
    static interface Printable {
        String print(String prefix, String suffix);
    }

    static String printThing(Printable thing) {
        return thing.print("Crying", " Meow!!!");
    }
}
