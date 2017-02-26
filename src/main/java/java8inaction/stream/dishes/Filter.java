package java8inaction.stream.dishes;

import java.util.Arrays;

import static java.lang.System.out;

public class Filter {
    public static void main(String[] args) {
        // filter
        Menu.menu.stream().filter(Dish::isVegetarian)
                .forEach(out::println);
        System.out.println();

        // distinct
        Arrays.asList(1, 2, 1, 3, 4, 5, 2).stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(out::println);
        System.out.println();

        // limit
        Menu.menu.stream().filter(d -> d.getCalories() > 300)
                .limit(3)
                .forEach(out::println);
        System.out.println();

        // skip
        Menu.menu.stream().filter(d -> d.getCalories() > 300)
                .skip(2)
                .forEach(out::println);
    }
}
