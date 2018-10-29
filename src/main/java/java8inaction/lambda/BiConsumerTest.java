package java8inaction.lambda;

import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        ObjIntConsumer objIntConsumer;
        BiConsumer<Apple, String> biConsumer = (apple, s) -> System.out.println(apple + " is " + s);
        BiConsumer<Apple, String> compConsumer = biConsumer.andThen(biConsumer);
        compConsumer.accept(Apple.create(10, Color.Blue), "Blue");
    }
}
