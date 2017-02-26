package java8inaction.stream.Dishes;

import java.util.Optional;

import static java8inaction.stream.Dishes.Menu.menu;
import static java8inaction.stream.Dishes.Numbers.numbers;

public class Reduce {
    public static void main(String[] args) {
        // reduce
        Integer reduce = numbers.stream().reduce(0, (x, y) -> x + y);
        Integer reduce1 = numbers.stream().reduce(0, Integer::sum);
        Optional<Integer> optional = numbers.stream().reduce(Integer::sum);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        numbers.stream().reduce(Integer::min);
        Integer dishMapToIntCount = menu.stream().map(dish -> 1).reduce(0, Integer::sum);
        long dishCount = menu.stream().count();


    }
}
