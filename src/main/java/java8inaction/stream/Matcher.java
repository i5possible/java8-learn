package java8inaction.stream;

import java.util.Optional;

import static java8inaction.stream.Menu.menu;
import static java8inaction.stream.Numbers.numbers;

public class Matcher {
    public static void main(String[] args) {
        // anyMatch
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly");
        }

        // allMatch
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);

        // noneMatch
        boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        // findAny
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        dish.ifPresent(d -> System.out.println(d.getName()));

        // findFirst
        // findAny is faster than findFirst because the findAry can run parallel
        Optional<Integer> first = numbers.stream()
                .map(x -> x * x).filter(x -> x % 2 == 0).findFirst();
    }
}
