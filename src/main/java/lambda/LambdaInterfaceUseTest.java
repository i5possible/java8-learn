package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaInterfaceUseTest {
    public static void main(String[] args) {
        Function<Integer, Double> toDouble = (a) -> a.doubleValue();
        BiFunction<Integer, Double, String> toString = (a, b) -> "" + a + b;
    }
}
