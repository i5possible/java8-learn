package java8inaction.stream.dishes;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateStream {
    public static void main(String[] args) {
        Stream<String> java8 = Stream.of("Java8", "Lambdas", "in", "Action");
        Stream<Object> empty = Stream.empty();

        // it's ok
        int[] numbers = {2, 3, 4, 5, 6, 7};
        Arrays.stream(numbers);
        Arrays.asList("String", "is", "OK").stream();
        // it has error
        // Arrays.stream(2,3,4,5,6,7);

        // Generate stream from file
        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Infinite Stream
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        System.out.println();

        // Fibonacci
        Stream.iterate(new int[]{0, 1}, array -> new int[]{array[1], array[0] + array[1]})
                .limit(10)
                .forEach(array -> System.out.println(array[0] + ", " + array[1]));
        System.out.println();

        IntSupplier fibonacciSupplier = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int oldPrevious = previous;
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fibonacciSupplier).limit(10)
                .forEach(System.out::println);
        System.out.println();

        // Random
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
