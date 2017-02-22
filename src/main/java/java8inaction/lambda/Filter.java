package java8inaction.lambda;

import lambda.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        Predicate<Apple> predicate = apple -> apple.getWeight() > 30;

    }

    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (Color.Green.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterGreenAppleNew(List<Apple> inventory) {
        return filterApple(inventory, apple -> Color.Green.equals(apple.getColor()));
    }

    public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> predicate) {
        return inventory.stream().filter(predicate).collect(Collectors.toList());
    }
}
