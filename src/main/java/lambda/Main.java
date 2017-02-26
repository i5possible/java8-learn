package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        Comparator<Apple> comparing = comparing(Apple::getWeight);
        Comparator<String> cmp = Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER);
        ArrayList<Apple> list = new ArrayList<>();
        list.sort(comparing);

        Comparator<Apple> reversed = comparing.reversed();
        Comparator<Apple> appleComparator = comparing.reversed().thenComparing(Apple::getColor);
        comparing.reversed().thenComparing(Apple::getTaste);

        Predicate<Apple> redApple = (apple -> apple.getColor().equals(Color.Red));
        Predicate<Apple> nonRedApple = redApple.negate();
        redApple.negate().or(apple -> apple.getWeight() == 150).and(apple -> apple.getTaste().equals("delicious"));

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);
        System.out.println(h.apply(1)); //4
        System.out.println(h.apply(2)); //6
        System.out.println();
        System.out.println(h2.apply(1)); //3
        System.out.println(h2.apply(2)); //5
    }
}
