package java8inaction.stream.Dishes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Mapping {
    public static void main(String[] args) {
        // map
        Menu.menu.stream().map(Dish::getName).forEach(out::println);
        System.out.println();

        Arrays.asList("Java8", "Lambda", "In", "Action").stream()
                .map(s -> s + " length : " + s.length())
                .forEach(out::println);
        System.out.println();

        Menu.menu.stream().map(Dish::getName)
                .map(String::length)
                .forEach(out::println);
        System.out.println();

        // flat map
        List<String> collect = Arrays.asList("Good night,", " World!").stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("length : " + collect.size());
        System.out.println();

        // test
        Arrays.asList(1, 2, 3, 4, 5).stream().map(n -> n * n)
                .forEach(out::println);
        System.out.println();

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3);
        list1.stream().forEach(num1 -> list2.stream().forEach(
                num2 -> System.out.println("[" + num1 + "," + num2 + "]")));
        System.out.println();

        list1.stream().forEach(num1 -> list2.stream()
                .filter(num2 -> (num1 + num2) % 3 == 0)
                .forEach(num2 -> System.out.println("[" + num1 + "," + num2 + "]")));


    }
}
