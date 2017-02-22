package java8inaction.lambda;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        IntConsumer intConsumer;
        DoubleConsumer doubleConsumer;
    }
}
