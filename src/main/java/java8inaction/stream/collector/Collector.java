package java8inaction.stream.collector;

import java8inaction.stream.dishes.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;
import static java8inaction.stream.dishes.Menu.menu;

public class Collector {
    public static void main(String[] args) {
        menu.stream().collect(toList());

        // maxBy
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> collect = menu.stream().collect(maxBy(dishCaloriesComparator));

        // sum
        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        // average
        Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);
        System.out.println();

        String allDishNames = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(allDishNames);
        System.out.println();

        // TODO This is introduced in the book, but there is some error
//        menu.stream().collect(joining(", "));

        // reduce
        Integer totalCaloriesUsingReducing = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> dishOptional = menu.stream().collect(
                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));


        Integer collect1 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));

        Integer integer = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

        int sum = menu.stream().mapToInt(Dish::getCalories).sum();

    }
}
