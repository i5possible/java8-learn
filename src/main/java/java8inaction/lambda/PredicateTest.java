package java8inaction.lambda;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> nonEmpty = s -> !s.isEmpty();
        IntPredicate intPredicate = i -> i % 2 == 0;
        DoublePredicate doublePredicate;

        Predicate<Apple> redApple = apple -> Color.Red.equals(apple.getColor());
        Predicate<Apple> notRedApple = redApple.negate();

        redApple.and(a -> a.getWeight() > 150);

        redApple.or(a -> a.getWeight() > 150).and(a -> a.getWeight() < 500);
    }
}
