package java8inaction.lambda;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (a , b) -> a + b;
        LongBinaryOperator longBinaryOperator;
        DoubleBinaryOperator doubleBinaryOperator;
        BinaryOperator<Apple> appleBinaryOperator = (a,b) -> a.getWeight() > b.getWeight() ? a : b;
    }
}
