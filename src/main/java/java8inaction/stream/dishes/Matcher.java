package java8inaction.stream.dishes;

import java.util.Optional;

public class Matcher {
    public static void main(String[] args) {
        // anyMatch
        if (Menu.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly");
        }

        // allMatch
        boolean isHealthy = Menu.menu.stream().allMatch(d -> d.getCalories() < 1000);

        // noneMatch
        boolean isHealthy2 = Menu.menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        // findAny
        Optional<Dish> dish = Menu.menu.stream().filter(Dish::isVegetarian).findAny();
        dish.ifPresent(d -> System.out.println(d.getName()));

        // findFirst
        // findAny is faster than findFirst because the findAry can run parallel
        Optional<Integer> first = Numbers.numbers.stream()
                .map(x -> x * x).filter(x -> x % 2 == 0).findFirst();
    }
}
