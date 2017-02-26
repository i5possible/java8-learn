package java8inaction.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FruitInventor {
    static Map<String, BiFunction<Integer, Color, Fruit>> map = new HashMap();

    static {
        map.put("apple", Apple::new);
    }

    public static Fruit giveFruit(String fruit, Integer weight, Color color) {
        return map.get(fruit.toLowerCase()).apply(weight, color);
    }
}

