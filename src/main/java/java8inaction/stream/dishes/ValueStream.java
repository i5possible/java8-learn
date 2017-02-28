package java8inaction.stream.dishes;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java8inaction.stream.dishes.Menu.menu;

public class ValueStream {
    public static void main(String[] args) {
        Integer calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        // .sum(); ?

        // mapToInt / mapToDouble / mapToLong
        int caloriesInt = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        // .average();
        // .min();
        // .max();

        // boxed
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();

        // OptionalInt
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();

        //
        int max = maxCalories.orElse(1);

        // ** Range ** //
        IntStream.rangeClosed(1, 5).forEach(System.out::println);
        System.out.println();
        IntStream.range(1, 5).forEach(System.out::println);
        System.out.println();

        IntStream evenNum = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNum.count());
        System.out.println();

        // Pythagoras' theorem
        // a * a + b * b = c * c

        // ThreeIntTuple

        // Filter :
        // filter ( second -> Math.sqrt(first * first + second * second ) % 1 == 0)

        // Generator ThreeIntTuple
        // map(second -> new ThreeIntTuple(first, second, third));

        // intStream -> boxed -> Stream -> mapToObj

        // rangeClosed(1, 100).boxed

        Stream<double[]> stream = IntStream.rangeClosed(1, 100).boxed().flatMap(first ->
                IntStream.rangeClosed(first, 100).mapToObj(second ->
                        new double[]{first, second, Math.sqrt(first * first + second * second)})
                        .filter(doubleList -> doubleList[2] % 1 == 0)

        );

        stream.limit(5).forEach(doubleArray -> System.out.println(doubleArray[0] + ", "
                + doubleArray[1] + ", " + doubleArray[2]));
    }
}
