package java8inaction.lambda;

import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class FunctionTest {
    public static void main(String[] args) {
        IntToDoubleFunction intToDoubleFunction;
        DoubleToIntFunction doubleToIntFunction;
        DoubleToLongFunction doubleToLongFunction;

        Function<Integer, Integer> function = x -> x * x;
        Function<Integer, Integer> function1 = x -> x + 1;
        Function<Integer, Integer> h = function.andThen(function1);
        Function<Integer, Integer> h2 = function.compose(function1);
        System.out.println("10 is expected: " + h.apply(3));
        System.out.println("16 is expected: " + h2.apply(3));
    }
}
