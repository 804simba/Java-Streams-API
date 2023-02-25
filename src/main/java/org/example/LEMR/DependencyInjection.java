package org.example.LEMR;

public class DependencyInjection {
    interface Food {
        void makeFood();
    }

    static class Burger implements Food {
        @Override
        public void makeFood() {
            System.out.println("making burger...");
        }
    }

    static class Pizza implements Food {
        @Override
        public void makeFood() {
            System.out.println("Making pizza...");
        }
    }

    static class Chef {
        private Food food;

        public Chef(Food food) {
            this.food = food;
        }

        public void prepareFood() {
            // do something with burger object.
            food.makeFood();
        }
    }

    public static void main(String[] args) {
        // passing the dependency to the constructor during the object creation time.
        // Thus, the dependency was provided from outside. This way it is no longer
        // the dependent class' responsibility to figure out what is changing.
        // If a Java class creates an instance of a dependency inside the constructor,
        // it cannot be used and tested independently of this class. Because it becomes tied to
        // this class and Open for modification. (HARD DEPENDENCY)

        Chef pizzaChef = new Chef(new Pizza());
        Chef burgerChef = new Chef(new Burger());
        pizzaChef.prepareFood();
        burgerChef.prepareFood();
    }
}
