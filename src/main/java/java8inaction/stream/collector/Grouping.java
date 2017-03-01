package java8inaction.stream.collector;

import java8inaction.stream.dishes.Dish;
import java8inaction.stream.dishes.Type;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static java8inaction.stream.dishes.Menu.menu;

public class Grouping {
    public enum CaloricLevel {
        DIET,
        NORMAL,
        FAT
    }

    public static void main(String[] args) {
        // groupingBy
        Map<Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        Map<CaloricLevel, List<Dish>> caloricLevelListMap = menu.stream().collect(
                groupingBy(Grouping::getCaloricLevel)
        );
        System.out.println("caloricLevelListMap:");
        System.out.println(caloricLevelListMap);

        Map<Type, Map<CaloricLevel, List<Dish>>> typeCaloricLevelMap = menu.stream().collect(groupingBy(Dish::getType,
                groupingBy(Grouping::getCaloricLevel)));
        System.out.println("typeCaloricLevelMap:");
        System.out.println(typeCaloricLevelMap);

        Map<Type, Long> typeCountMap = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println("typeCountMap:");
        System.out.println(typeCountMap);

        // groupingBy(f) equals groupingBy(f, toList())
        Map<Type, List<Dish>> collect1 = menu.stream().collect(groupingBy(Dish::getType));
        Map<Type, List<Dish>> collect2 = menu.stream().collect(groupingBy(Dish::getType, toList()));

        Map<Type, Optional<Dish>> typeMaxCaloriesMapOptional = menu.stream().collect(groupingBy(Dish::getType,
                maxBy(comparingInt(Dish::getCalories))));
        System.out.println("typeMaxCaloriesMapOptional:");
        System.out.println(typeMaxCaloriesMapOptional);

        // collectingAndThen
        Map<Type, Dish> typeMaxCaloriesMap = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("typeMaxCaloriesMap:");
        System.out.println(typeMaxCaloriesMap);

        Map<Type, Integer> typeCaloriesSumMap = menu.stream().collect(groupingBy(
                Dish::getType, summingInt(Dish::getCalories)));
        System.out.println("typeCaloriesSumMap");
        System.out.println(typeCaloriesSumMap);

        Map<Type, Set<CaloricLevel>> typeCaloricLevelSet = menu.stream().collect(groupingBy(Dish::getType,
                mapping(Grouping::getCaloricLevel, toSet())));
        System.out.println("typeCaloricLevelSet");
        System.out.println(typeCaloricLevelSet);

        // you can explicitly use HashSet by calling its construction method
        Map<Type, HashSet<CaloricLevel>> typeHashSetMap = menu.stream().collect(groupingBy(Dish::getType,
                mapping(Grouping::getCaloricLevel, toCollection(HashSet::new))));

    }

    private static CaloricLevel getCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        } else if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
        }
    }
}
