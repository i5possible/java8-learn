package java8inaction.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        Comparator<Apple> comparing = Comparator.comparing(Apple::getWeight);
        IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
        LongBinaryOperator longBinaryOperator;
        DoubleBinaryOperator doubleBinaryOperator;
        BinaryOperator<Apple> appleBinaryOperator = (a, b) -> a.getWeight() > b.getWeight() ? a : b;
        int i = intBinaryOperator.applyAsInt(1, 3);
        BinaryOperator<Apple> appleBinaryOperator1 = BinaryOperator.minBy(comparing);
    }
}
