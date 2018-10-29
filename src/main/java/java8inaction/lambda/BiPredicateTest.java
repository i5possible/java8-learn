package java8inaction.lambda;

import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String[] args) {
        BiPredicate<Apple, Integer> biPredicate = (apple, integer) -> apple.getWeight() > integer;
        boolean test = biPredicate.negate().test(Apple.create(123, Color.Blue), 23);
        System.out.println(test);
    }
}
