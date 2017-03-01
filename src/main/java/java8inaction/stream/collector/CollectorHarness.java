package java8inaction.stream.collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java8inaction.stream.collector.PrimeNumbersCollector.isPrime;

public class CollectorHarness {
    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10;i ++) {
            long start = System.nanoTime();
//            Partition.partitionPrimes(1_000_000);
            PrimeNumbersCollector.partitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
            System.out.println("Faster execution done in " + fastest + " msecs");
        }
    }

    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(
                () -> new HashMap<Boolean, List<Integer>>() {{
                    put(true, new ArrayList<Integer>());
                    put(false, new ArrayList<Integer>());
                }},
                (acc, candidate) -> {
                    acc.get(isPrime(acc.get(true), candidate)).add(candidate);

                },
                (map1, map2) -> {
                    map1.get(true).addAll(map2.get(true));
                    map1.get(false).addAll(map2.get(false));
                }
        );
    }
}
