package lambda;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        Comparator<Apple> comparing = comparing(Apple::getWeight);
        Comparator<String> cmp = Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER);
        ArrayList<Apple> list = new ArrayList<>();
        list.sort(comparing);
    }
}
