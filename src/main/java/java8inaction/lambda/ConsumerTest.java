package java8inaction.lambda;

import java.util.function.Consumer;

public class ConsumerTest {

    private final static String name = "Ma XiaoQiang";

    public static void main(String[] args) {
        Consumer consumer = System.out::println;

        Consumer printTwice = (name) -> {
            System.out.println("1: " + name);
            System.out.println("2: " + name);
        };

        Consumer<String> ddd = (String adf) -> {

        };

        handleEvent(consumer);
        handleEvent(printTwice);
    }

    private static void handleEvent(Consumer<String> consumer){
        consumer.accept(name);
    }
}
