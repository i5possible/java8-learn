package java8inaction.lambda;

import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;

public class BiFunctionTest {
    public static void main(String[] args) {
        ToIntBiFunction<Apple, Apple> toIntBiFunction = ((apple, apple2) -> apple.getWeight() + apple2.getWeight());
        ToDoubleBiFunction toDoubleBiFunction;
        BiFunction<Apple, Apple, Integer> biFunction = ((apple, apple2) -> apple.getWeight() + apple2.getWeight());
    }
}
