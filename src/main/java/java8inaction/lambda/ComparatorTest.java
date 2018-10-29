package java8inaction.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(comparing(Apple::getWeight));
        Comparator<Apple> c = Comparator.comparing(Apple::getColor);
        c.reversed();
        Comparator<Apple> appleComparator = c.reversed().thenComparing(Apple::getWeight);
    }
}
