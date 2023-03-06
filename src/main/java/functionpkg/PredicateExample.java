package functionpkg;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<Integer> ages = List.of(17, 18,29,10, 30, 45, 28, 62, 7, 11, 10);
        Predicate<Integer> isAdult = new NotLessThan18<>();
        ages.stream().filter(isAdult).forEach(System.out::println);

        Predicate<Integer> adultYet = i -> i >= 18;
        Predicate<Integer> adultStill = i -> i < 65;
        System.out.println(adultYet.and(adultStill).test(5));
        System.out.println(adultYet.and(adultStill).test(38));
        System.out.println(adultYet.and(adultStill).test(90));
    }
}
class NotLessThan18<E> implements Predicate<Integer> {
    @Override
    public boolean test(Integer age) {
        final Integer ADULT = 18;
        return age >= ADULT;
    }
}
