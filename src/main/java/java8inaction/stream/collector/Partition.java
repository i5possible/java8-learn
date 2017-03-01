package java8inaction.stream.collector;

import java8inaction.stream.dishes.Dish;
import java8inaction.stream.dishes.Type;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static java8inaction.stream.dishes.Menu.menu;

public class Partition {
    public static void main(String[] args) {
        // partitioningBy
        Map<Boolean, List<Dish>> isVegetarianMap = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(isVegetarianMap);
        System.out.println(isVegetarianMap.get(true));
        System.out.println();

        Map<Boolean, Map<Type, List<Dish>>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                groupingBy(Dish::getType)));
        System.out.println(collect);
        System.out.println();

        Map<Boolean, Dish> collect1 = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect1);
        System.out.println();

        Map<Boolean, Map<Boolean, List<Dish>>> collect2 = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(collect2);
        System.out.println();

        // Dish::getType is not a predicate
//        menu.stream().collect(partitioningBy(Dish::isVegetarian,
//                partitioningBy(Dish::getType)));

        Map<Boolean, Long> vegetarianCounting = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting()));
        System.out.println(vegetarianCounting);
        System.out.println();

        System.out.println(Partition.partitionPrimes(100));
    }

    public static boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrimeFaster(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(Partition::isPrimeFaster));
    }
}

